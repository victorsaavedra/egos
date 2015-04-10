ALTER TABLE servei ADD id_estat integer NOT NULL;
CREATE TABLE estat (
	id_estat integer NOT NULL,
	nom varchar(30) NOT NULL
);
ALTER TABLE estat ADD CONSTRAINT PK_ESTAT PRIMARY KEY(id_estat);
ALTER TABLE servei ADD CONSTRAINT FK_SERVEI_ESTAT FOREIGN KEY (id_estat) REFERENCES estat(id_estat) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE responsable ADD password varchar(20) NOT NULL;
ALTER TABLE responsable ADD cognoms varchar(100) NOT NULL;
ALTER TABLE responsable ADD username varchar(15) NOT NULL;
