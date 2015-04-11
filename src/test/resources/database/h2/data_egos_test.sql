-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICI TAULAS MESTRES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************

-- SERVEI
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (1, 1, 1, 1, 'Descripció 1', 5, 5, 5, 'url explotació 1', 1, 1, 1, 'Grup Gauss 1', 'URL de proves 1', 1, 1, 1, 'Nom del servei 1', 1, 1, '2008-12-02', 1);
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (2, 2, 1, 1, 'Descripció 2', 5, 5, 5, 'url explotació 2', 1, 1, 1, 'Grup Gauss 2', 'URL de proves 2', 1, 1, 1, 'Nom del servei 2', 2, 2, '2009-12-02', 2);
insert into servei (id_servei, id_sistema_informacio, dades_personals, nivell_seguretat, descripcio, cua_internet, temps_intranet, concurrencia_intranet, url_explotacio, acces_intranet, acces_internet, cua_intranet, grup_gauss, url_proves, concurrencia_internet, temps_internet, validacio, nom, id_estat, id_metamodel, data_alta, id_tecnologia) values (3, 3, 1, 1, 'Descripció 3', 5, 5, 5, 'url explotació 3', 1, 1, 1, 'Grup Gauss 3', 'URL de proves 3', 1, 1, 1, 'Nom del servei 3', 3, 3, '2010-12-02', 3);

-- SISTEMA_INFORMACIO
insert into sistema_informacio (id_sistema_informacio, nom) values (1, 'Sistema Informacio 1');
insert into sistema_informacio (id_sistema_informacio, nom) values (2, 'Sistema Informacio 2');
insert into sistema_informacio (id_sistema_informacio, nom) values (3, 'Sistema Informacio 3');

-- SUBSCRIPCIO
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (1, 1, 'Subscripcio 1', 'URL test 1', 'URL explotació 1', 'Estimació dus 1', 'Descripció 1', 'Comentari 1', 1, 4);
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (2, 1, 'Subscripcio 2', 'URL test 2', 'URL explotació 2', 'Estimació dus 2', 'Descripció 2', 'Comentari 2', 1, 4);
insert into subscripcio (id_subscripcio, id_sistema_informacio, nom, url_test, url_explotacio, estimacio_us, descripcio, comentari, horari, id_estat) values (3, 1, 'Subscripcio 3', 'URL test 3', 'URL explotació 3', 'Estimació dus 3', 'Descripció 3', 'Comentari 3', 1, 4);

-- OPERACIO
insert into operacio (id_operacio, id_servei, nom, descripcio) values (1, 1, 'Nom Operació 1', 'Descripcio operació 1');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (2, 1, 'Nom Operació 2', 'Descripcio operació 2');
insert into operacio (id_operacio, id_servei, nom, descripcio) values (3, 2, 'Nom Operació 3', 'Descripcio operació 3');

-- TECNOLOGIA
insert into tecnologia (id_tecnologia, nom) values (1, 'Tecnologia 1');
insert into tecnologia (id_tecnologia, nom) values (2, 'Tecnologia 2');
insert into tecnologia (id_tecnologia, nom) values (3, 'Tecnologia 3')

-- METAMODEL
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (1, 'Metamodel 1', 1, 6);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (2, 'Metamodel 2', 1, 2);
insert into metamodel (id_metamodel, nom, jumbo, ordre) values (3, 'Metamodel 3', 2, 0);

-- COMENTARI
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(1, '2014-08-22', 1, 1, 'Comentari 1', null, 1, 1);
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(2, '2014-08-23', 1, 2, 'Comentari 2', null, 1, 2);
insert into comentari (id_comentari, data_comentari, vist, id_responsable, comentari, id_subscripcio, id_servei, id_responsable_objectiu) values(3, '2014-08-23', 0, 3, 'Comentari 3', null, 1, 1);


-- RESPONSABLE
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (1, 'Responsable 1', '','responsable1','admin','999999999', 'a@a.com', 1, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (2, 'Responsable 2', '','responsable2','admin','999999999', 'b@a.com', 2, 'UPCNet');
insert into responsable (id_responsable, nom, cognoms, username, password, telefon, mail, id_rol, departament) values (3, 'Responsable 3', '','responsable3','admin','999999999', 'c@a.com', 3, 'UPCNet');

-- ROL
insert into rol (id_rol, nomCognoms) values (1, 'Rol 1');
insert into rol (id_rol, nomCognoms) values (2, 'Rol 2');
insert into rol (id_rol, nomCognoms) values (3, 'Rol 3');

-- ETIQUETA
insert into etiqueta (id_etiqueta, nom) values (1, 'Etiqueta 1');
insert into etiqueta (id_etiqueta, nom) values (2, 'Etiqueta 2');
insert into etiqueta (id_etiqueta, nom) values (3, 'Etiqueta 3');

-- ESTAT
insert into estat (id_estat, nom) values (1, 'Estat 1');
insert into estat (id_estat, nom) values (2, 'Estat 2');
insert into estat (id_estat, nom) values (3, 'Estat 3');

-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> FI TAULES MESTRES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************

-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> INICI TAULES DADES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************
-- SERVEI_RESPONSABLE
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (1, 1, 1);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (2, 1, 2);
insert into servei_responsable (id_servei_responsable, id_servei, id_responsable) values (3, 2, 1);

-- SUBSCRIPCIO_OPERACIO
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (1, 1, 1);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (2, 1, 2);
insert into subscripcio_operacio (id_subscripcio_operacio, id_subscripcio, id_operacio) values (3, 2, 3);

-- SUBSCRIPCIO_RESPONSABLE
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (1, 1, 1);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (2, 2, 1);
insert into subscripcio_responsable (id_subscripcio_responsable, id_subscripcio, id_responsable) values (3, 2, 2);

-- TIPUS_IP
insert into tipus_ip (id_tipus_ip,nom) values (1,'Tipus Ip 1');
insert into tipus_ip (id_tipus_ip,nom) values (2,'Tipus Ip 2');
insert into tipus_ip (id_tipus_ip,nom) values (2,'Tipus Ip 3');

-- SERVEI_IP
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(1, 1, 1, '1.1.1.1');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(2, 1, 2, '2.2.2.2');
insert into servei_ip (id_servei_ip, id_servei, id_tipus_ip, ip) values(3, 2, 3, '3.3.3.3');

-- SUBSCRIPCIO_IP
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (1, 1, 1, '1.1.1.1');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (2, 1, 2, '2.2.2.2');
insert into subscripcio_ip (id_subscripcio_ip, id_subscripcio, id_tipus_ip, ip) values (3, 3, 3, '3.3.3.3');

-- SERVEI_ETIQUETA
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (1, 1, 1);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (2, 1, 2);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (3, 1, 3);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (4, 2, 1);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (5, 2, 2);
insert into servei_etiqueta (id_servei_etiqueta, id_servei, id_etiqueta) values (6, 3, 1);


-- **************************************************************************************************************************
-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> FI TAULES DADES <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
-- **************************************************************************************************************************

