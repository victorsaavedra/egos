CREATE TABLE servei_etiqueta (
	id_servei_etiqueta integer NOT NULL,
	id_servei integer NOT NULL,
	id_etiqueta integer NOT NULL
);
ALTER TABLE servei_etiqueta ADD CONSTRAINT PK_SERVEI_ETIQUETA PRIMARY KEY(id_servei_etiqueta);
CREATE TABLE etiqueta (
	id_etiqueta integer NOT NULL,
	nom varchar(50) NOT NULL,
	numero integer NOT NULL DEFAULT 0
);
ALTER TABLE etiqueta ADD CONSTRAINT PK_ETIQUETA PRIMARY KEY(id_etiqueta);
ALTER TABLE servei_etiqueta ALTER id_servei_etiqueta TYPE integer;
ALTER TABLE etiqueta ALTER id_etiqueta TYPE integer;
ALTER TABLE servei_etiqueta ADD CONSTRAINT FK_SERVEI_ETIQUETA__SERVEI FOREIGN KEY (id_servei) REFERENCES servei(id_servei) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE servei_etiqueta ADD CONSTRAINT FK_SERVEI_ETIQUETA__ETIQUETA FOREIGN KEY (id_etiqueta) REFERENCES etiqueta(id_etiqueta) ON DELETE NO ACTION ON UPDATE NO ACTION;
