-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICI TAULAS MESTRES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************
--tipus_ip
insert into tipus_ip (id_tipus_ip,nom) values (1,'Explotació');
insert into tipus_ip (id_tipus_ip,nom) values (2,'Test');

--metamodel
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (1, 'Alumne', 1, 6);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (2, 'Identitat', 1, 2);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (3, 'Docencia', 1, 3);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (4, 'Doctorands', 1, 4);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (5, 'Biblioteques', 1, 5);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (6, 'Firmes', 0, null);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (7, 'Tots', 1 ,1);

--tecnologia
insert into tecnologia (id_tecnologia, nom) values (1, 'JSON');
insert into tecnologia (id_tecnologia, nom) values (2, 'HTML');
insert into tecnologia (id_tecnologia, nom) values (3, 'SOAP');
insert into tecnologia (id_tecnologia, nom) values (4, 'RSS');

--sistema_informacio
insert into sistema_informacio (id_sistema_informacio, nom) values (1, 'Drac');
insert into sistema_informacio (id_sistema_informacio, nom) values (2, 'Prisma');
insert into sistema_informacio (id_sistema_informacio, nom) values (3, 'SBD');
--etiqueta
insert into etiqueta (id_etiqueta, nom) values (1, 'informació');
insert into etiqueta (id_etiqueta, nom) values (2, 'recerca');
insert into etiqueta (id_etiqueta, nom) values (3, 'grup');
insert into etiqueta (id_etiqueta, nom) values (4, 'pdi');
insert into etiqueta (id_etiqueta, nom) values (5, 'dades');
insert into etiqueta (id_etiqueta, nom) values (6, 'alumnes');
insert into etiqueta (id_etiqueta, nom) values (7, 'curriculum');
insert into etiqueta (id_etiqueta, nom) values (8, 'memoria');
insert into etiqueta (id_etiqueta, nom) values (9, 'activitats');
insert into etiqueta (id_etiqueta, nom) values (10, 'drac');
insert into etiqueta (id_etiqueta, nom) values (11, 'persones');

--estat
insert into estat (id_estat, nom) values (1, 'Esborrany');
insert into estat (id_estat, nom) values (2, 'En valoració');
insert into estat (id_estat, nom) values (3, 'En tràmit');
insert into estat (id_estat, nom) values (4, 'Publicat');
insert into estat (id_estat, nom) values (5, 'Baixa');

 
--rol
insert into rol (id_rol, nomCognoms) values (1, 'Administrador');
insert into rol (id_rol, nomCognoms) values (2, 'Responsable');
insert into rol (id_rol, nomCognoms) values (3, 'Responsable técnic');


--responsable
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (1, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'a@a.com', 1, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (2, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'b@a.com', 2, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (3, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'c@a.com', 3, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (4, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'd@a.com', 1, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (5, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'e@a.com', 2, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (6, 'Víctor', 'Saavedra Martínez','vsaavedra','admin','999999999', 'f@a.com', 3, 'UPCNet');

--servei
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (1, 1, 1, 1, 'Descripció 1', 5, 5, 5, 'url explotació 1', 1, 1, 1, 'Grup Gauss 1', 'URL de proves 1', 1, 1, 1, 'Nom del servei 1', 4, 1, '2008-12-02', 1);
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (2, 2, 1, 1, 'Descripció 2', 5, 5, 5, 'url explotació 2', 1, 1, 1, 'Grup Gauss 2', 'URL de proves 2', 1, 1, 1, 'Nom del servei 2', 4, 2, '2009-12-02', 2);
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (3, 3, 1, 1, 'Descripció 3', 5, 5, 5, 'url explotació 3', 1, 1, 1, 'Grup Gauss 3', 'URL de proves 3', 1, 1, 1, 'Nom del servei 3', 3, 3, '2010-12-02', 3);

--subscripcio
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (1, 1, 'Servei 1', 'URL test 1', 'URL explotació 1', 'Estimació dus 1', 'Descripció 1', 'Comentari 1', 1, 4);
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (2, 1, 'Servei 2', 'URL test 2', 'URL explotació 2', 'Estimació dus 2', 'Descripció 2', 'Comentari 2', 1, 4);
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (3, 1, 'Servei 3', 'URL test 3', 'URL explotació 3', 'Estimació dus 3', 'Descripció 3', 'Comentari 3', 1, 4);



--comentari
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(1, '2014-08-22', 1, 2, 'Prueba comentario 1', null, 1, 1);
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(2, '2014-08-23', 1, 3, 'Prueba comentario 2', null, 1, 2);
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(3, '2014-08-23', 0, 2, 'Prueba comentario 3 alerta', null, 1, 1);




-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> FI TAULES MESTRES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************

-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICI TAULES DADES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************

--servei_ip
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(1, 1, 1, '198.168.0.1');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(2, 1, 1, '198.168.0.2');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(3, 1, 2, '198.168.0.3');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(4, 2, 1, '198.168.0.4');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(5, 2, 2, '198.168.0.5');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(6, 2, 2, '198.168.0.6');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(7, 3, 1, '198.168.0.1');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(8, 3, 1, '198.168.0.1');

--servei_responsable
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (1, 2, 1);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (2, 2, 1);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (3, 2, 2);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (4, 3, 3);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (5, 3, 4);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (6, 3, 5);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (7, 3, 6);

--servei_etiqueta
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (1, 1, 1);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (2, 1, 2);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (3, 1, 3);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (4, 1, 4);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (5, 1, 5);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (6, 1, 6);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (7, 1, 7);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (8, 1, 8);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (9, 1, 9);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (10, 1, 10);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (11, 2, 11);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (12, 2, 1);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (13, 2, 2);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (14, 2, 3);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (15, 2, 4);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (16, 2, 5);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (17, 2, 9);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (18, 2, 11);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (19, 2, 8);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (20, 3, 1);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (21, 3, 2);

--operacio
insert into operacio (id_operacio, id_servei, nom, descripcio) values (1, 1, 'Nom Operació 1', 'Descripcio operació 1');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (2, 1, 'Nom Operació 2', 'Descripcio operació 2');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (3, 1, 'Nom Operació 3', 'Descripcio operació 3');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (4, 1, 'Nom Operació 4', 'Descripcio operació 4');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (5, 2, 'Nom Operació 5', 'Descripcio operació 5');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (6, 2, 'Nom Operació 6', 'Descripcio operació 6');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (7, 3, 'Nom Operació 7', 'Descripcio operació 7');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (8, 3, 'Nom Operació 8', 'Descripcio operació 8');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (9, 3, 'Nom Operació 9', 'Descripcio operació 9');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (10, 3 ,'Nom Operació 10', 'Descripcio operació 10');

--subscripcio_ip
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (1, 1, 1, '198.168.0.1');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (2, 1, 1, '198.168.0.2');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (3, 1, 2, '198.168.0.3');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (4, 2, 1, '198.168.0.4');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (5, 2, 2, '198.168.0.5');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (6, 2, 2, '198.168.0.6');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (7, 3, 1, '198.168.0.1');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (8, 3, 1, '198.168.0.1');

--subscripcio_operacio
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (1, 1, 2);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (2, 1, 4);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (3, 2, 5);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (4, 2, 6);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (5, 3, 8);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (6, 3, 9);

--subscripcio_responsable
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (1, 1, 1);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (2, 2, 1);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (3, 2, 2);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (4, 3, 3);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (5, 3, 4);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (6, 3, 5);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (7, 3, 6);









