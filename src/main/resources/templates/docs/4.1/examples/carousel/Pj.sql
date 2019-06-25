CREATE TABLE cliente
(
  id int(10) NOT NULL,
  nome character varying(50) NOT NULL,
  email character varying(20) NOT NULL,
  cpf character varying(15) NOT NULL,
  idade character varying(20),
  classif bolean NOT NULL,
  endereco character varying(30) NOT NULL,
  cidade character varying(20) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE eventoComp
(
  id int(10) NOT NULL,
  nome character varying(50) NOT NULL,
  tipo character varying(15) NOT NULL,
  dono character varying(20),
  email character varying(20) NOT NULL,
  endereco character varying(30) NOT NULL,
  referencia character varying(30) NOT NULL,
  cidade character varying(20) NOT NULL,
  estado character varying(2) NOT NULL,
  valor int(10) NOT NULL,
  descricao character varying(500) NOT NULL,
  faixa_etaria character varying(10) NOT NULL,
  horario character varying(10), 
  PRIMARY KEY (id)
)

CREATE TABLE eventoBanner
(
  id int(10) NOT NULL,
  nome character varying(50) NOT NULL,
  descricao character varying(500) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE eventoFeed
(
  id int(10) NOT NULL,
  nome character varying(50) NOT NULL,
  descricao character varying(500) NOT NULL,  
  PRIMARY KEY (id)
)

CREATE TABLE eventoCard
(
  id int(10) NOT NULL,
  nome character varying(50) NOT NULL,
  endereco character varying(30) NOT NULL,
  valor int(10) NOT NULL,
  descricao character varying(500) NOT NULL,
  faixa_etaria character varying(10) NOT NULL,
  horario character varying(10),
  
  PRIMARY KEY (id)
)