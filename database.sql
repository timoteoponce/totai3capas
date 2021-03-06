;              
CREATE USER IF NOT EXISTS APP SALT 'a88ef975d2c001c1' HASH '7d2dca2a76b4a643419f02034e7628fb6efe38032afa10bf560e5d6b216ed16e' ADMIN;           
CREATE CACHED TABLE PUBLIC.AULA(
    ID VARCHAR(255) NOT NULL,
    CAPACIDAD INTEGER
);        
ALTER TABLE PUBLIC.AULA ADD CONSTRAINT PUBLIC.CONSTRAINT_1 PRIMARY KEY(ID);    
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.AULA;     
CREATE CACHED TABLE PUBLIC.CURSO(
    CODIGO VARCHAR(255) NOT NULL,
    DURACIONHORAS INTEGER,
    TEMA VARCHAR(255),
    TITULO VARCHAR(255)
);               
ALTER TABLE PUBLIC.CURSO ADD CONSTRAINT PUBLIC.CONSTRAINT_3 PRIMARY KEY(CODIGO);               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.CURSO;    
INSERT INTO PUBLIC.CURSO(CODIGO, DURACIONHORAS, TEMA, TITULO) VALUES
('1', 5, '1', '1');       
CREATE CACHED TABLE PUBLIC.DIA(
    ID VARCHAR(255) NOT NULL
);
ALTER TABLE PUBLIC.DIA ADD CONSTRAINT PUBLIC.CONSTRAINT_10 PRIMARY KEY(ID);    
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.DIA;      
CREATE CACHED TABLE PUBLIC.EDICION(
    ID VARCHAR(255) NOT NULL,
    FECHAFIN DATE,
    FECHAINICIO DATE,
    AULA_ID VARCHAR(255),
    CURSO_CODIGO VARCHAR(255),
    DOCENTE_CI INTEGER
);  
ALTER TABLE PUBLIC.EDICION ADD CONSTRAINT PUBLIC.CONSTRAINT_B PRIMARY KEY(ID); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.EDICION;  
CREATE CACHED TABLE PUBLIC.EMPLEADO(
    CI INTEGER NOT NULL,
    FECHAINGRESO DATE,
    NOMBRE VARCHAR(255)
);
ALTER TABLE PUBLIC.EMPLEADO ADD CONSTRAINT PUBLIC.CONSTRAINT_7 PRIMARY KEY(CI);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.EMPLEADO; 
CREATE CACHED TABLE PUBLIC.INSCRIPCION(
    ID_ALUMNO INTEGER NOT NULL,
    ID_EDICION VARCHAR(255) NOT NULL,
    FECHAINSCRIPCION DATE,
    NOTA INTEGER
);   
ALTER TABLE PUBLIC.INSCRIPCION ADD CONSTRAINT PUBLIC.CONSTRAINT_9 PRIMARY KEY(ID_ALUMNO, ID_EDICION);          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INSCRIPCION;              
CREATE CACHED TABLE PUBLIC.DIAS_CLASE(
    EDICION_ID VARCHAR(255) NOT NULL,
    DIASCLASE_ID VARCHAR(255) NOT NULL
);         
ALTER TABLE PUBLIC.DIAS_CLASE ADD CONSTRAINT PUBLIC.CONSTRAINT_5 PRIMARY KEY(EDICION_ID, DIASCLASE_ID);        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.DIAS_CLASE;               
CREATE CACHED TABLE PUBLIC.REQUISITO(
    CURSO_CODIGO VARCHAR(255) NOT NULL,
    REQUISITOS_CODIGO VARCHAR(255) NOT NULL
);   
ALTER TABLE PUBLIC.REQUISITO ADD CONSTRAINT PUBLIC.CONSTRAINT_C PRIMARY KEY(CURSO_CODIGO, REQUISITOS_CODIGO);  
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.REQUISITO;
ALTER TABLE PUBLIC.EDICION ADD CONSTRAINT PUBLIC.FKF2A8D34FCD996425 FOREIGN KEY(CURSO_CODIGO) REFERENCES PUBLIC.CURSO(CODIGO) NOCHECK;         
ALTER TABLE PUBLIC.DIAS_CLASE ADD CONSTRAINT PUBLIC.FK44262A26A37A430 FOREIGN KEY(DIASCLASE_ID) REFERENCES PUBLIC.DIA(ID) NOCHECK;             
ALTER TABLE PUBLIC.EDICION ADD CONSTRAINT PUBLIC.FKF2A8D34FB0D40D37 FOREIGN KEY(ID) REFERENCES PUBLIC.EDICION(ID) NOCHECK;     
ALTER TABLE PUBLIC.EDICION ADD CONSTRAINT PUBLIC.FKF2A8D34FD5BFF371 FOREIGN KEY(DOCENTE_CI) REFERENCES PUBLIC.EMPLEADO(CI) NOCHECK;            
ALTER TABLE PUBLIC.DIAS_CLASE ADD CONSTRAINT PUBLIC.FK44262A2C669CC07 FOREIGN KEY(EDICION_ID) REFERENCES PUBLIC.EDICION(ID) NOCHECK;           
ALTER TABLE PUBLIC.REQUISITO ADD CONSTRAINT PUBLIC.FK2994CE0327274F71 FOREIGN KEY(REQUISITOS_CODIGO) REFERENCES PUBLIC.CURSO(CODIGO) NOCHECK;  
ALTER TABLE PUBLIC.REQUISITO ADD CONSTRAINT PUBLIC.FK2994CE03CD996425 FOREIGN KEY(CURSO_CODIGO) REFERENCES PUBLIC.CURSO(CODIGO) NOCHECK;       
ALTER TABLE PUBLIC.EDICION ADD CONSTRAINT PUBLIC.FKF2A8D34F3C62078D FOREIGN KEY(AULA_ID) REFERENCES PUBLIC.AULA(ID) NOCHECK;   
