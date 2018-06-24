DROP DATABASE IF EXISTS bdhr;

CREATE DATABASE bdhr;

USE bdhr;

CREATE TABLE tblperfil(CVIDPRF BIGINT NOT NULL AUTO_INCREMENT,
                       CCDSPRF VARCHAR(50) NOT NULL,
                       CONSTRAINT PK_tblperfil PRIMARY KEY(CVIDPRF),
                       CONSTRAINT CCDSPRF UNIQUE(CCDSPRF));

CREATE TABLE tblfuncionario(CVMATFUN BIGINT NOT NULL,
                            CCNOMFUN VARCHAR(100) NOT NULL,
                            CCNOMCRG VARCHAR(100) NOT NULL,
                            CVIDPRF BIGINT NOT NULL,
                            CCUSR VARCHAR(100) NOT NULL,
                            CCPWD VARCHAR(100) NOT NULL,
                            CONSTRAINT PK_tblfuncionario PRIMARY KEY(CVMATFUN),
                            CONSTRAINT FK_tblfuncionario_CVIDPRF FOREIGN KEY(CVIDPRF) REFERENCES tblperfil(CVIDPRF),
                            CONSTRAINT UNQ_CCUSR UNIQUE (CCUSR));

CREATE TABLE tblatestado(CVIDATST BIGINT NOT NULL AUTO_INCREMENT,
						 CVMATFUN BIGINT NOT NULL,
						 CCCID VARCHAR(10) DEFAULT NULL,
                         CDDTINI DATE NOT NULL,
                         CVQTDDIAS BIGINT NOT NULL,
                         CCCRM VARCHAR(20) NOT NULL,
                         CCNOMMED VARCHAR(100) NOT NULL,
                         CONSTRAINT PK_tblatestado PRIMARY KEY(CVIDATST),
                         CONSTRAINT FK_tblatestado_CVMATFUN FOREIGN KEY(CVMATFUN) REFERENCES tblfuncionario(CVMATFUN));

CREATE TABLE tblfrequencia(CDDTFREQ DATETIME DEFAULT CURRENT_TIMESTAMP,
						   CVANOREF LONG AS (YEAR(DATE(CDDTFREQ))),
                           CVMESREF LONG AS (MONTH(DATE(CDDTFREQ))),
						   CVMATFUN BIGINT NOT NULL,
                           CONSTRAINT PK_tblfrequencia PRIMARY KEY(CVMATFUN,CDDTFREQ),
                           CONSTRAINT FK_tblfrequencia_CVMATFUN FOREIGN KEY(CVMATFUN) REFERENCES tblfuncionario(CVMATFUN));
                           
       
INSERT INTO tblperfil(CCDSPRF)VALUES('RH');
INSERT INTO tblperfil(CCDSPRF)VALUES('ENGENHARIA');
INSERT INTO tblperfil(CCDSPRF)VALUES('COMERCIAL');
INSERT INTO tblfuncionario (CVMATFUN,CCNOMFUN,CCNOMCRG,CVIDPRF,CCUSR,CCPWD) VALUES(12345,'ADMIN','ADMIN',1,'admin','12345');
INSERT INTO tblfuncionario (CVMATFUN,CCNOMFUN,CCNOMCRG,CVIDPRF,CCUSR,CCPWD) VALUES(45678,'JOAO DOS SANTOS','ANL ENG',2,'joao','12345');
INSERT INTO tblfuncionario (CVMATFUN,CCNOMFUN,CCNOMCRG,CVIDPRF,CCUSR,CCPWD) VALUES(91011,'MARIA DA SILVA','ANL ENG',3,'maria','12345');



                           