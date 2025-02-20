## Start LDAP

### OpenLDAP

1. Run ldap container
~~~
podman run -d --name sso-ldap --env LDAP_ORGANISATION=keycloak --env LDAP_DOMAIN=keycloak.org --env LDAP_ADMIN_PASSWORD=admin -p 10389:389 --replace osixia/openldap:1.5.0
~~~

2. Download the test LDIF file https://raw.githubusercontent.com/keycloak/keycloak/release/22.0/examples/ldap/ldap-example-users.ldif

~~~
wget https://raw.githubusercontent.com/keycloak/keycloak/release/22.0/examples/ldap/ldap-example-users.ldif
~~~

3. Add the LDIF to the LDAP
~~~
ldapadd -D "cn=admin,dc=keycloak,dc=org" -w admin -f ~/Downloads/ldap-example-users.ldif -c -H ldap://127.0.0.1:10389
~~~

4. Info

- Connection URL: ldap://127.0.0.1:10389
- Bind DN: cn=admin,dc=keycloak,dc=org
- Bind credentials: admin
- Users DN: ou=People,dc=keycloak,dc=org
- RDN LDAP attribute: uid

### Elytron Setup

1. Configure LDAP context

~~~
/subsystem=elytron/dir-context=ldap-dir-context:add(url="ldap://localhost:10389",principal="cn=admin,dc=keycloak,dc=org",credential-reference={clear-text="admin"}, referral-mode=follow)
~~~

2. LDAP realm and Security domain, member={1} on the role filter refers to user DN, member={0} refers to user RDN(in the example below, it should be "uid")

~~~
/subsystem=elytron/ldap-realm=ldap-realm:add(dir-context=ldap-dir-context, direct-verification="true",identity-mapping={rdn-identifier="uid", attribute-mapping=[{filter-base-dn="ou=RealmRoles,dc=keycloak,dc=org",filter="(&(objectClass=groupOfNames)(member={1}))",from="cn",to="Roles", role-recursion="5"}], search-base-dn="ou=People,dc=keycloak,dc=org", use-recursive-search="false"})

/subsystem=elytron/simple-role-decoder=from-roles-attribute:add(attribute=Roles)

/subsystem=elytron/security-domain=ldap-security-domain:add(realms=[{realm=ldap-realm,role-decoder=from-roles-attribute}],default-realm=ldap-realm,permission-mapper=default-permission-mapper)
~~~

3. HTTP authentication factory
~~~
/subsystem=elytron/http-authentication-factory=ldap-http-auth:add(http-server-mechanism-factory=global,security-domain=ldap-security-domain,mechanism-configurations=[{mechanism-name=BASIC,mechanism-realm-configurations=[{realm-name=ldap-realm}]}])
~~~

* Undertow

~~~
/subsystem=undertow/application-security-domain=httpSD:add(http-authentication-factory=ldap-http-auth)
~~~