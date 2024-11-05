JSP JAAS Example
===

Need to change the configuration `http-authentication-factory` from `BASIC` to `FORM` on `standalone-ha.xml`:

```
<http-authentication-factory name="example-loginconfig-http-auth" security-domain="mySD" http-server-mechanism-factory="global">
                    <mechanism-configuration>
                        <mechanism mechanism-name="BASIC">
                            <mechanism-realm realm-name="FSRealmUsers"/>
                        </mechanism>
                    </mechanism-configuration>
                </http-authentication-factory>
```

to 

~~~
<http-authentication-factory name="example-loginconfig-http-auth" security-domain="mySD" http-server-mechanism-factory="global">
                    <mechanism-configuration>
                        <mechanism mechanism-name="FORM">
                            <mechanism-realm realm-name="FSRealmUsers"/>
                        </mechanism>
                    </mechanism-configuration>
                </http-authentication-factory>
~~~~