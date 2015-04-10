CREATE SEQUENCE SEQUENCE_SISTEMA_INFORMACIO START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_TECNOLOGIA START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_METAMODEL START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SERVEI START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SUBSCRIPCIO START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SERVEI_IP START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_TIPUS_IP START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SUBSCRIPCIO_IP START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SUBSCRIPCIO_OPERACIO START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SUBSCRIPCIO_RESPONSABLE START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_OPERACIO START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SERVEI_RESPONSABLE START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_RESPONSABLE START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_COMENTARI START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_ROL START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_ESTAT START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_ETIQUETA START 1 INCREMENT 1;
CREATE SEQUENCE SEQUENCE_SERVEI_ETIQUETA START 1 INCREMENT 1;

CREATE TABLE servei (
	id_servei integer NOT NULL DEFAULT nextval('SEQUENCE_SERVEI'),
	id_sistema_informacio integer NOT NULL,
	dades_personals integer,
	nivell_seguretat integer,
	descripcio text,
	cua_internet integer,
	temps_intranet integer,
	concurrencia_intranet integer,
	url_explotacio varchar(100),
	acces_intranet integer,
	acces_internet integer,
	cua_intranet integer,
	grup_gauss varchar(100),
	url_proves varchar(100),
	concurrencia_internet integer,
	temps_internet integer,
	validacio integer,
	nom varchar(50),
	id_estat integer NOT NULL,
	data_alta date,
	id_tecnologia integer NOT NULL,
	data_baixa date,
	id_metamodel integer NOT NULL
);
ALTER TABLE servei ADD CONSTRAINT PK_SERVEI PRIMARY KEY(id_servei);
CREATE TABLE sistema_informacio (
	id_sistema_informacio integer NOT NULL DEFAULT nextval('SEQUENCE_SISTEMA_INFORMACIO'),
	nom varchar(150) NOT NULL
);
ALTER TABLE sistema_informacio ADD CONSTRAINT PK_SISTEMA_INFORMACIO PRIMARY KEY(id_sistema_informacio);
CREATE TABLE subscripcio (
	id_subscripcio integer NOT NULL DEFAULT nextval('SEQUENCE_SUBSCRIPCIO'),
	id_sistema_informacio integer NOT NULL,
	nom varchar(50),
	url_test varchar(100),
	url_explotacio varchar(100),
	estimacio_us varchar(20),
	descripcio text,
	comentari text,
	horari integer,
	data_alta date,
	id_estat integer,
	data_baixa date
);
ALTER TABLE subscripcio ADD CONSTRAINT PK_SUBSCRIPCIO PRIMARY KEY(id_subscripcio);
CREATE TABLE subscripcio_operacio (
	id_subscripcio_operacio integer NOT NULL DEFAULT nextval('SEQUENCE_SUBSCRIPCIO_OPERACIO'),
	id_subscripcio integer NOT NULL,
	id_operacio integer NOT NULL
);
ALTER TABLE subscripcio_operacio ADD CONSTRAINT PK_SUBSCRIPCIO_OPERACIO PRIMARY KEY(id_subscripcio_operacio);
CREATE TABLE operacio (
	id_operacio integer NOT NULL DEFAULT nextval('SEQUENCE_OPERACIO'),
	id_servei integer NOT NULL,
	nom varchar(50) NOT NULL,
	descripcio text NOT NULL
);
ALTER TABLE operacio ADD CONSTRAINT PK_OPERACIO PRIMARY KEY(id_operacio);
CREATE TABLE tecnologia (
	id_tecnologia integer NOT NULL DEFAULT nextval('SEQUENCE_TECNOLOGIA'),
	nom varchar(50)
);
ALTER TABLE tecnologia ADD CONSTRAINT PK_TECNOLOGIA PRIMARY KEY(id_tecnologia);
CREATE TABLE metamodel (
	id_metamodel integer NOT NULL DEFAULT nextval('SEQUENCE_METAMODEL'),
	nom varchar(50),
	jumbo integer NOT NULL,
	ordre integer
);
ALTER TABLE metamodel ADD CONSTRAINT PK_METAMODEL PRIMARY KEY(id_metamodel);
CREATE TABLE comentari (
	id_comentari integer NOT NULL DEFAULT nextval('SEQUENCE_COMENTARI'),
	data_comentari date NOT NULL,
	vist integer NOT NULL,
	id_responsable integer NOT NULL,
	comentari text NOT NULL,
	id_subscripcio integer,
	id_servei integer,
	id_responsable_objectiu integer NOT NULL
);
ALTER TABLE comentari ADD CONSTRAINT PK_COMENTARI PRIMARY KEY(id_comentari);
CREATE TABLE servei_responsable (
	id_servei_responsable integer NOT NULL DEFAULT nextval('SEQUENCE_SERVEI_RESPONSABLE'),
	id_servei integer NOT NULL,
	id_responsable integer NOT NULL
);
ALTER TABLE servei_responsable ADD CONSTRAINT PK_SERVEI_RESPONSABLE PRIMARY KEY(id_servei_responsable);
CREATE TABLE responsable (
	id_responsable integer NOT NULL DEFAULT nextval('SEQUENCE_RESPONSABLE'),
	nom_cognoms varchar(100) NOT NULL,
	telefon varchar(20) NOT NULL,
	mail varchar(50) NOT NULL,
	id_rol integer NOT NULL,
	departament varchar(50) NOT NULL,
	password varchar(20) NOT NULL,
	username varchar(15) NOT NULL
);
ALTER TABLE responsable ADD CONSTRAINT PK_RESPONSABLE PRIMARY KEY(id_responsable);
CREATE TABLE subscripcio_responsable (
	id_subscripcio_responsable integer NOT NULL DEFAULT nextval('SEQUENCE_SUBSCRIPCIO_RESPONSABLE'),
	id_subscripcio integer NOT NULL,
	id_responsable integer NOT NULL
);
ALTER TABLE subscripcio_responsable ADD CONSTRAINT PK_SUBSCRIPCIO_RESPONSABLE PRIMARY KEY(id_subscripcio_responsable);
CREATE TABLE rol (
	id_rol integer NOT NULL DEFAULT nextval('SEQUENCE_ROL'),
	nom varchar(20) NOT NULL
);
ALTER TABLE rol ADD CONSTRAINT PK_ROL PRIMARY KEY(id_rol);
CREATE TABLE tipus_ip (
	id_tipus_ip integer NOT NULL DEFAULT nextval('SEQUENCE_TIPUS_IP'),
	nom varchar(20) NOT NULL
);
ALTER TABLE tipus_ip ADD CONSTRAINT PK_TIPUS_IP PRIMARY KEY(id_tipus_ip);
CREATE TABLE servei_ip (
	id_servei integer NOT NULL DEFAULT nextval('SEQUENCE_SERVEI_IP'),
	id_tipus_ip integer NOT NULL,
	ip varchar(15) NOT NULL,
	id_servei_ip integer NOT NULL
);
ALTER TABLE servei_ip ADD CONSTRAINT PK_SERVEI_IP PRIMARY KEY(id_servei_ip);
CREATE TABLE subscripcio_ip (
	id_subscripcio_ip integer NOT NULL DEFAULT nextval('SEQUENCE_SUBSCRIPCIO_IP'),
	id_subscripcio integer NOT NULL,
	id_tipus_ip integer NOT NULL,
	ip varchar(15) NOT NULL
);
ALTER TABLE subscripcio_ip ADD CONSTRAINT PK_SUBSCRIPCIO_IP PRIMARY KEY(id_subscripcio_ip);
CREATE TABLE servei_etiqueta (
	id_servei_etiqueta integer NOT NULL DEFAULT nextval('SEQUENCE_SERVEI_ETIQUETA'),
	id_servei integer NOT NULL,
	id_etiqueta integer NOT NULL
);
ALTER TABLE servei_etiqueta ADD CONSTRAINT PK_SERVEI_ETIQUETA PRIMARY KEY(id_servei_etiqueta);
CREATE TABLE etiqueta (
	id_etiqueta integer NOT NULL DEFAULT nextval('SEQUENCE_ETIQUETA'),
	nom varchar(50) NOT NULL
);
ALTER TABLE etiqueta ADD CONSTRAINT PK_ETIQUETA PRIMARY KEY(id_etiqueta);
CREATE TABLE estat (
	id_estat integer NOT NULL,
	nom varchar(30) NOT NULL
);
ALTER TABLE estat ADD CONSTRAINT PK_ESTAT PRIMARY KEY(id_estat);
ALTER TABLE servei ADD CONSTRAINT FK_SERVEI_SISTEMA_INFORMACIO FOREIGN KEY (id_sistema_informacio) REFERENCES sistema_informacio(id_sistema_informacio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE subscripcio ADD CONSTRAINT FK_SUBSCRIPCIO_SISTEMA_INFORMACIO FOREIGN KEY (id_sistema_informacio) REFERENCES sistema_informacio(id_sistema_informacio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE subscripcio_operacio ADD CONSTRAINT FK_SUBSCRIPCIO_OPERACIO__SUBSCRIPCIO FOREIGN KEY (id_subscripcio) REFERENCES subscripcio(id_subscripcio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE subscripcio_operacio ADD CONSTRAINT FK_SUBSCRIPCIO_OPERACIO__OPERACIO FOREIGN KEY (id_operacio) REFERENCES operacio(id_operacio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_responsable ADD CONSTRAINT FK_SERVEI_RESPONSABLE__SERVEI FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_responsable ADD CONSTRAINT FK_SERVEI_RESPONSABLE__RESPONSABLE FOREIGN KEY (id_responsable) REFERENCES responsable(id_responsable) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE subscripcio_responsable ADD CONSTRAINT FK_SUBSCRIPCIO_RESPONSABLE__SUBSCRIPCIO FOREIGN KEY (id_subscripcio) REFERENCES subscripcio(id_subscripcio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE subscripcio_responsable ADD CONSTRAINT FK_SUBSCRIPCIO_RESPONSABLE__RESPONSABLE FOREIGN KEY (id_responsable) REFERENCES responsable(id_responsable) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE operacio ADD CONSTRAINT FK_SERVEI_OPERACIO FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE responsable ADD CONSTRAINT FK_RESPONSABLE_ROL FOREIGN KEY (id_rol) REFERENCES rol(id_rol) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE servei_ip ADD CONSTRAINT FK_SERVEI_IP FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_ip ADD CONSTRAINT FK_SERVEI_TIPUS_IP FOREIGN KEY (id_tipus_ip) REFERENCES tipus_ip(id_tipus_ip) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE subscripcio_ip ADD CONSTRAINT FK_SUBSCRIPCIO_TIPUS_IP FOREIGN KEY (id_tipus_ip) REFERENCES tipus_ip(id_tipus_ip) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE subscripcio_ip ADD CONSTRAINT FK_SUBSCRIPCIO_IP FOREIGN KEY (id_subscripcio) REFERENCES subscripcio(id_subscripcio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE comentari ADD CONSTRAINT FK_RESPONSABLE_COMENTARI FOREIGN KEY (id_responsable) REFERENCES responsable(id_responsable) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE comentari ADD CONSTRAINT FK_SUBSCRIPCIO_COMENTARI FOREIGN KEY (id_subscripcio) REFERENCES subscripcio(id_subscripcio) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE comentari ADD CONSTRAINT FK_SERVEI_COMENTARI FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_etiqueta ADD CONSTRAINT FK_SERVEI_ETIQUETA__SERVEI FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_etiqueta ADD CONSTRAINT FK_SERVEI_ETIQUETA__ETIQUETA FOREIGN KEY (id_etiqueta) REFERENCES etiqueta(id_etiqueta) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE servei ADD CONSTRAINT FK_SERVEI_ESTAT FOREIGN KEY (id_estat) REFERENCES estat(id_estat) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE servei ADD CONSTRAINT FK_SERVEI_TECNOLOGIA FOREIGN KEY (id_tecnologia) REFERENCES tecnologia(id_tecnologia) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE servei ADD CONSTRAINT FK_SERVEI_METAMODEL FOREIGN KEY (id_metamodel) REFERENCES metamodel(id_metamodel) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE comentari ADD CONSTRAINT FK_COMENTARI_RESPONSABLEOBJECTIU FOREIGN KEY (id_responsable_objectiu) REFERENCES responsable(id_responsable) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE subscripcio ADD CONSTRAINT FK_SUBSCRIPCIO_ESTAT FOREIGN KEY (id_estat) REFERENCES estat(id_estat) ON DELETE NO ACTION ON UPDATE NO ACTION;
