insert into users (user_name, password, role, status) values ('daviggdd@gmail.com', '$2a$10$s4rY33tGyU.zJ5HG4ayqJe2TKVM.MlACavja1jWF2Sfd0xSlumx2e', 'ADMIN', 'active');
-- la pass es jmca


insert into role (description, role_name) values ('Usuarios Administradores','ADMIN');


INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('barakaldoapi', '$2a$10$d2tGk17EmAAUdkqoRLFwBe/L5z7YaSS12a68IPdStykgBWqDgs772', 'read,write',
    'authorization_code,refresh_token,password', null, null, 36000, 36000, null, true);





