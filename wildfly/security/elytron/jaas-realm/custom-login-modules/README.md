Custom Login Module Example
===

This example is based on [JAAS REALM Custom Login Modules](https://github.com/wildfly-security-incubator/elytron-examples/blob/main/jaas-realm/custom-login-modules/)

### Build

```
mvn clean install
```

### Deploy

```{bash}
batch

# add the JAAS module
module add --name=lm --resources=/home/pedro-hos/workspace/code/pessoal/myplayground/wildfly/security/elytron/jaas-realm/custom-login-modules/target/custom-login-modules-1.0.jar --dependencies=org.wildfly.security.elytron

# New Elytron Realm, JAAS Realm
/subsystem=elytron/jaas-realm=myRealm:add(entry=test,path=/home/pedro-hos/workspace/code/pessoal/myplayground/wildfly/security/elytron/jaas-realm/custom-login-modules/JAAS-login-modules.conf,module=lm,callback-handler=loginmodules.CustomCallbackHandler)

# New Elytron Security Domain, using the JAAS Realm Created before
/subsystem=elytron/security-domain=mySD:add(default-realm=myRealm,realms=[{realm=myRealm}],permission-mapper=default-permission-mapper)

# New Elytron HTTP Authentication Factory, using the Security Domain created before.
/subsystem=elytron/http-authentication-factory=example-loginconfig-http-auth:add(http-server-mechanism-factory="global",mechanism-configurations=[{mechanism-name="FORM",mechanism-realm-configurations=[{realm-name="FSRealmUsers"}]}],security-domain=mySD)

# EJB Application Security Domain using the Elytron Security Domain
/subsystem=ejb3/application-security-domain=other:write-attribute(name=security-domain,value=mySD)

# Web Undertow Application Security Domain, using the HTTP Authentication Factory
/subsystem=undertow/application-security-domain=other:write-attribute(name=http-authentication-factory,value=example-loginconfig-http-auth)

# undefine (remove) the old security domain used by default on Undertow
/subsystem=undertow/application-security-domain=other:undefine-attribute(name=security-domain)

run-batch
reload
```
