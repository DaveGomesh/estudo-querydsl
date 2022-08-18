--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

-- Started on 2022-08-18 08:32:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE empresa;
--
-- TOC entry 3339 (class 1262 OID 32792)
-- Name: empresa; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE empresa WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE empresa OWNER TO postgres;

\connect empresa

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 32810)
-- Name: depart_func; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.depart_func (
    id_depart_func integer NOT NULL,
    fk_departamento integer NOT NULL,
    fk_funcionario integer NOT NULL,
    data_inicio date NOT NULL,
    data_fim date
);


ALTER TABLE public.depart_func OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 32793)
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.departamento (
    id_departamento integer NOT NULL,
    nome character varying NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 32803)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id_funcionario integer NOT NULL,
    nome character varying NOT NULL,
    sobrenome character varying NOT NULL,
    data_nasc date NOT NULL,
    sexo character varying NOT NULL,
    data_admissao date NOT NULL
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 32827)
-- Name: salario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.salario (
    id_salario integer NOT NULL,
    fk_funcionario integer NOT NULL,
    valor integer NOT NULL,
    data_inicio date NOT NULL,
    data_fim date
);


ALTER TABLE public.salario OWNER TO postgres;

--
-- TOC entry 3332 (class 0 OID 32810)
-- Dependencies: 211
-- Data for Name: depart_func; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.depart_func VALUES (1, 5, 1, '1986-06-26', NULL);
INSERT INTO public.depart_func VALUES (2, 7, 2, '1996-08-03', NULL);
INSERT INTO public.depart_func VALUES (3, 4, 3, '1995-12-03', NULL);
INSERT INTO public.depart_func VALUES (4, 4, 4, '1986-12-01', NULL);
INSERT INTO public.depart_func VALUES (5, 3, 5, '1989-09-12', NULL);
INSERT INTO public.depart_func VALUES (6, 5, 6, '1990-08-05', NULL);
INSERT INTO public.depart_func VALUES (7, 8, 7, '1989-02-10', NULL);
INSERT INTO public.depart_func VALUES (8, 5, 8, '1998-03-11', '2000-07-31');
INSERT INTO public.depart_func VALUES (9, 6, 9, '1985-02-18', NULL);
INSERT INTO public.depart_func VALUES (10, 4, 10, '1996-11-24', '2000-06-26');
INSERT INTO public.depart_func VALUES (11, 6, 10, '2000-06-26', NULL);
INSERT INTO public.depart_func VALUES (12, 9, 11, '1990-01-22', '1996-11-09');
INSERT INTO public.depart_func VALUES (13, 5, 12, '1992-12-18', NULL);
INSERT INTO public.depart_func VALUES (14, 3, 13, '1985-10-20', NULL);
INSERT INTO public.depart_func VALUES (15, 5, 14, '1993-12-29', NULL);
INSERT INTO public.depart_func VALUES (16, 8, 15, '1992-09-19', '1993-08-22');
INSERT INTO public.depart_func VALUES (17, 7, 16, '1998-02-11', NULL);
INSERT INTO public.depart_func VALUES (18, 1, 17, '1993-08-03', NULL);
INSERT INTO public.depart_func VALUES (19, 4, 18, '1992-07-29', NULL);
INSERT INTO public.depart_func VALUES (20, 5, 18, '1987-04-03', '1992-07-29');
INSERT INTO public.depart_func VALUES (21, 8, 19, '1999-04-30', NULL);
INSERT INTO public.depart_func VALUES (22, 4, 20, '1997-12-30', NULL);
INSERT INTO public.depart_func VALUES (23, 5, 21, '1988-02-10', '2002-07-15');
INSERT INTO public.depart_func VALUES (24, 5, 22, '1999-09-03', NULL);
INSERT INTO public.depart_func VALUES (25, 5, 23, '1999-09-27', NULL);
INSERT INTO public.depart_func VALUES (26, 4, 24, '1998-06-14', NULL);
INSERT INTO public.depart_func VALUES (27, 5, 25, '1987-08-17', '1997-10-15');
INSERT INTO public.depart_func VALUES (28, 4, 26, '1995-03-20', NULL);
INSERT INTO public.depart_func VALUES (29, 5, 27, '1995-04-02', NULL);
INSERT INTO public.depart_func VALUES (30, 5, 28, '1991-10-22', '1998-04-06');
INSERT INTO public.depart_func VALUES (31, 4, 29, '1991-09-18', '1999-07-08');
INSERT INTO public.depart_func VALUES (32, 6, 29, '1999-07-08', NULL);
INSERT INTO public.depart_func VALUES (33, 4, 30, '1994-02-17', NULL);
INSERT INTO public.depart_func VALUES (34, 5, 31, '1991-09-01', NULL);
INSERT INTO public.depart_func VALUES (35, 4, 32, '1990-06-20', NULL);
INSERT INTO public.depart_func VALUES (36, 6, 33, '1987-03-18', '1993-03-24');
INSERT INTO public.depart_func VALUES (37, 7, 34, '1995-04-12', '1999-10-31');
INSERT INTO public.depart_func VALUES (38, 4, 35, '1988-09-05', NULL);
INSERT INTO public.depart_func VALUES (39, 3, 36, '1992-04-28', NULL);
INSERT INTO public.depart_func VALUES (40, 5, 37, '1990-12-05', NULL);
INSERT INTO public.depart_func VALUES (41, 9, 38, '1989-09-20', NULL);
INSERT INTO public.depart_func VALUES (42, 3, 39, '1988-01-19', NULL);
INSERT INTO public.depart_func VALUES (43, 5, 40, '1993-02-14', '2002-01-22');
INSERT INTO public.depart_func VALUES (44, 8, 40, '2002-01-22', NULL);
INSERT INTO public.depart_func VALUES (45, 7, 41, '1989-11-12', NULL);
INSERT INTO public.depart_func VALUES (46, 2, 42, '1993-03-21', '2000-08-10');
INSERT INTO public.depart_func VALUES (47, 5, 43, '1990-10-20', NULL);
INSERT INTO public.depart_func VALUES (48, 4, 44, '1994-05-21', NULL);
INSERT INTO public.depart_func VALUES (49, 4, 45, '1996-11-16', NULL);
INSERT INTO public.depart_func VALUES (50, 8, 46, '1992-06-20', NULL);


--
-- TOC entry 3330 (class 0 OID 32793)
-- Dependencies: 209
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.departamento VALUES (6, 'Atendimento ao Cliente');
INSERT INTO public.departamento VALUES (4, 'Desenvolvimento');
INSERT INTO public.departamento VALUES (8, 'Finanças');
INSERT INTO public.departamento VALUES (1, 'Gestão da Qualidade');
INSERT INTO public.departamento VALUES (3, 'Marketing');
INSERT INTO public.departamento VALUES (2, 'Pesquisa');
INSERT INTO public.departamento VALUES (5, 'Produção');
INSERT INTO public.departamento VALUES (7, 'Recursos Humanos');
INSERT INTO public.departamento VALUES (9, 'Vendas');


--
-- TOC entry 3331 (class 0 OID 32803)
-- Dependencies: 210
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.funcionario VALUES (1, 'Georgi', 'Facello', '1953-09-02', 'M', '1986-06-26');
INSERT INTO public.funcionario VALUES (2, 'Bezalel', 'Simmel', '1964-06-02', 'F', '1985-11-21');
INSERT INTO public.funcionario VALUES (3, 'Parto', 'Bamford', '1959-12-03', 'M', '1986-08-28');
INSERT INTO public.funcionario VALUES (4, 'Chirstian', 'Koblick', '1954-05-01', 'M', '1986-12-01');
INSERT INTO public.funcionario VALUES (5, 'Kyoichi', 'Maliniak', '1955-01-21', 'M', '1989-09-12');
INSERT INTO public.funcionario VALUES (6, 'Anneke', 'Preusig', '1953-04-20', 'F', '1989-06-02');
INSERT INTO public.funcionario VALUES (7, 'Tzvetan', 'Zielinski', '1957-05-23', 'F', '1989-02-10');
INSERT INTO public.funcionario VALUES (8, 'Saniya', 'Kalloufi', '1958-02-19', 'M', '1994-09-15');
INSERT INTO public.funcionario VALUES (9, 'Sumant', 'Peac', '1952-04-19', 'F', '1985-02-18');
INSERT INTO public.funcionario VALUES (10, 'Duangkaew', 'Piveteau', '1963-06-01', 'F', '1989-08-24');
INSERT INTO public.funcionario VALUES (11, 'Mary', 'Sluis', '1953-11-07', 'F', '1990-01-22');
INSERT INTO public.funcionario VALUES (12, 'Patricio', 'Bridgland', '1960-10-04', 'M', '1992-12-18');
INSERT INTO public.funcionario VALUES (13, 'Eberhardt', 'Terkki', '1963-06-07', 'M', '1985-10-20');
INSERT INTO public.funcionario VALUES (14, 'Berni', 'Genin', '1956-02-12', 'M', '1987-03-11');
INSERT INTO public.funcionario VALUES (15, 'Guoxiang', 'Nooteboom', '1959-08-19', 'M', '1987-07-02');
INSERT INTO public.funcionario VALUES (16, 'Kazuhito', 'Cappelletti', '1961-05-02', 'M', '1995-01-27');
INSERT INTO public.funcionario VALUES (17, 'Cristinel', 'Bouloucos', '1958-07-06', 'F', '1993-08-03');
INSERT INTO public.funcionario VALUES (18, 'Kazuhide', 'Peha', '1954-06-19', 'F', '1987-04-03');
INSERT INTO public.funcionario VALUES (19, 'Lillian', 'Haddadi', '1953-01-23', 'M', '1999-04-30');
INSERT INTO public.funcionario VALUES (20, 'Mayuko', 'Warwick', '1952-12-24', 'M', '1991-01-26');
INSERT INTO public.funcionario VALUES (21, 'Ramzi', 'Erde', '1960-02-20', 'M', '1988-02-10');
INSERT INTO public.funcionario VALUES (22, 'Shahaf', 'Famili', '1952-07-08', 'M', '1995-08-22');
INSERT INTO public.funcionario VALUES (23, 'Bojan', 'Montemayor', '1953-09-29', 'F', '1989-12-17');
INSERT INTO public.funcionario VALUES (24, 'Suzette', 'Pettey', '1958-09-05', 'F', '1997-05-19');
INSERT INTO public.funcionario VALUES (25, 'Prasadram', 'Heyers', '1958-10-31', 'M', '1987-08-17');
INSERT INTO public.funcionario VALUES (26, 'Yongqiao', 'Berztiss', '1953-04-03', 'M', '1995-03-20');
INSERT INTO public.funcionario VALUES (27, 'Divier', 'Reistad', '1962-07-10', 'F', '1989-07-07');
INSERT INTO public.funcionario VALUES (28, 'Domenick', 'Tempesti', '1963-11-26', 'M', '1991-10-22');
INSERT INTO public.funcionario VALUES (29, 'Otmar', 'Herbst', '1956-12-13', 'M', '1985-11-20');
INSERT INTO public.funcionario VALUES (30, 'Elvis', 'Demeyer', '1958-07-14', 'M', '1994-02-17');
INSERT INTO public.funcionario VALUES (31, 'Karsten', 'Joslin', '1959-01-27', 'M', '1991-09-01');
INSERT INTO public.funcionario VALUES (32, 'Jeong', 'Reistad', '1960-08-09', 'F', '1990-06-20');
INSERT INTO public.funcionario VALUES (33, 'Arif', 'Merlo', '1956-11-14', 'M', '1987-03-18');
INSERT INTO public.funcionario VALUES (34, 'Bader', 'Swan', '1962-12-29', 'M', '1988-09-21');
INSERT INTO public.funcionario VALUES (35, 'Alain', 'Chappelet', '1953-02-08', 'M', '1988-09-05');
INSERT INTO public.funcionario VALUES (36, 'Adamantios', 'Portugali', '1959-08-10', 'M', '1992-01-03');
INSERT INTO public.funcionario VALUES (37, 'Pradeep', 'Makrucki', '1963-07-22', 'M', '1990-12-05');
INSERT INTO public.funcionario VALUES (38, 'Huan', 'Lortz', '1960-07-20', 'M', '1989-09-20');
INSERT INTO public.funcionario VALUES (39, 'Alejandro', 'Brender', '1959-10-01', 'M', '1988-01-19');
INSERT INTO public.funcionario VALUES (40, 'Weiyi', 'Meriste', '1959-09-13', 'F', '1993-02-14');
INSERT INTO public.funcionario VALUES (41, 'Uri', 'Lenart', '1959-08-27', 'F', '1989-11-12');
INSERT INTO public.funcionario VALUES (42, 'Magy', 'Stamatiou', '1956-02-26', 'F', '1993-03-21');
INSERT INTO public.funcionario VALUES (43, 'Yishay', 'Tzvieli', '1960-09-19', 'M', '1990-10-20');
INSERT INTO public.funcionario VALUES (44, 'Mingsen', 'Casley', '1961-09-21', 'F', '1994-05-21');
INSERT INTO public.funcionario VALUES (45, 'Moss', 'Shanbhogue', '1957-08-14', 'M', '1989-09-02');
INSERT INTO public.funcionario VALUES (46, 'Lucien', 'Rosenbaum', '1960-07-23', 'M', '1992-06-20');
INSERT INTO public.funcionario VALUES (47, 'Zvonko', 'Nyanchama', '1952-06-29', 'M', '1989-03-31');
INSERT INTO public.funcionario VALUES (48, 'Florian', 'Syrotiuk', '1963-07-11', 'M', '1985-02-24');
INSERT INTO public.funcionario VALUES (49, 'Basil', 'Tramer', '1961-04-24', 'F', '1992-05-04');
INSERT INTO public.funcionario VALUES (50, 'Yinghua', 'Dredge', '1958-05-21', 'M', '1990-12-25');


--
-- TOC entry 3333 (class 0 OID 32827)
-- Dependencies: 212
-- Data for Name: salario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.salario VALUES (1, 1, 60117, '1986-06-26', '1987-06-26');
INSERT INTO public.salario VALUES (2, 1, 62102, '1987-06-26', '1988-06-25');
INSERT INTO public.salario VALUES (3, 1, 66074, '1988-06-25', '1989-06-25');
INSERT INTO public.salario VALUES (4, 1, 66596, '1989-06-25', '1990-06-25');
INSERT INTO public.salario VALUES (5, 1, 66961, '1990-06-25', '1991-06-25');
INSERT INTO public.salario VALUES (6, 1, 71046, '1991-06-25', '1992-06-24');
INSERT INTO public.salario VALUES (7, 1, 74333, '1992-06-24', '1993-06-24');
INSERT INTO public.salario VALUES (8, 1, 75286, '1993-06-24', '1994-06-24');
INSERT INTO public.salario VALUES (9, 1, 75994, '1994-06-24', '1995-06-24');
INSERT INTO public.salario VALUES (10, 1, 76884, '1995-06-24', '1996-06-23');
INSERT INTO public.salario VALUES (11, 1, 80013, '1996-06-23', '1997-06-23');
INSERT INTO public.salario VALUES (12, 1, 81025, '1997-06-23', '1998-06-23');
INSERT INTO public.salario VALUES (13, 1, 81097, '1998-06-23', '1999-06-23');
INSERT INTO public.salario VALUES (14, 1, 84917, '1999-06-23', '2000-06-22');
INSERT INTO public.salario VALUES (15, 1, 85112, '2000-06-22', '2001-06-22');
INSERT INTO public.salario VALUES (16, 1, 85097, '2001-06-22', '2002-06-22');
INSERT INTO public.salario VALUES (17, 1, 88958, '2002-06-22', NULL);
INSERT INTO public.salario VALUES (18, 2, 65828, '1996-08-03', '1997-08-03');
INSERT INTO public.salario VALUES (19, 2, 65909, '1997-08-03', '1998-08-03');
INSERT INTO public.salario VALUES (20, 2, 67534, '1998-08-03', '1999-08-03');
INSERT INTO public.salario VALUES (21, 2, 69366, '1999-08-03', '2000-08-02');
INSERT INTO public.salario VALUES (22, 2, 71963, '2000-08-02', '2001-08-02');
INSERT INTO public.salario VALUES (23, 2, 72527, '2001-08-02', NULL);
INSERT INTO public.salario VALUES (24, 3, 40006, '1995-12-03', '1996-12-02');
INSERT INTO public.salario VALUES (25, 3, 43616, '1996-12-02', '1997-12-02');
INSERT INTO public.salario VALUES (26, 3, 43466, '1997-12-02', '1998-12-02');
INSERT INTO public.salario VALUES (27, 3, 43636, '1998-12-02', '1999-12-02');
INSERT INTO public.salario VALUES (28, 3, 43478, '1999-12-02', '2000-12-01');
INSERT INTO public.salario VALUES (29, 3, 43699, '2000-12-01', '2001-12-01');
INSERT INTO public.salario VALUES (30, 3, 43311, '2001-12-01', NULL);
INSERT INTO public.salario VALUES (31, 4, 40054, '1986-12-01', '1987-12-01');
INSERT INTO public.salario VALUES (32, 4, 42283, '1987-12-01', '1988-11-30');
INSERT INTO public.salario VALUES (33, 4, 42542, '1988-11-30', '1989-11-30');
INSERT INTO public.salario VALUES (34, 4, 46065, '1989-11-30', '1990-11-30');
INSERT INTO public.salario VALUES (35, 4, 48271, '1990-11-30', '1991-11-30');
INSERT INTO public.salario VALUES (36, 4, 50594, '1991-11-30', '1992-11-29');
INSERT INTO public.salario VALUES (37, 4, 52119, '1992-11-29', '1993-11-29');
INSERT INTO public.salario VALUES (38, 4, 54693, '1993-11-29', '1994-11-29');
INSERT INTO public.salario VALUES (39, 4, 58326, '1994-11-29', '1995-11-29');
INSERT INTO public.salario VALUES (40, 4, 60770, '1995-11-29', '1996-11-28');
INSERT INTO public.salario VALUES (41, 4, 62566, '1996-11-28', '1997-11-28');
INSERT INTO public.salario VALUES (42, 4, 64340, '1997-11-28', '1998-11-28');
INSERT INTO public.salario VALUES (43, 4, 67096, '1998-11-28', '1999-11-28');
INSERT INTO public.salario VALUES (44, 4, 69722, '1999-11-28', '2000-11-27');
INSERT INTO public.salario VALUES (45, 4, 70698, '2000-11-27', '2001-11-27');
INSERT INTO public.salario VALUES (46, 4, 74057, '2001-11-27', NULL);
INSERT INTO public.salario VALUES (47, 5, 78228, '1989-09-12', '1990-09-12');
INSERT INTO public.salario VALUES (48, 5, 82621, '1990-09-12', '1991-09-12');
INSERT INTO public.salario VALUES (49, 5, 83735, '1991-09-12', '1992-09-11');
INSERT INTO public.salario VALUES (50, 5, 85572, '1992-09-11', '1993-09-11');
INSERT INTO public.salario VALUES (51, 5, 85076, '1993-09-11', '1994-09-11');
INSERT INTO public.salario VALUES (52, 5, 86050, '1994-09-11', '1995-09-11');
INSERT INTO public.salario VALUES (53, 5, 88448, '1995-09-11', '1996-09-10');
INSERT INTO public.salario VALUES (54, 5, 88063, '1996-09-10', '1997-09-10');
INSERT INTO public.salario VALUES (55, 5, 89724, '1997-09-10', '1998-09-10');
INSERT INTO public.salario VALUES (56, 5, 90392, '1998-09-10', '1999-09-10');
INSERT INTO public.salario VALUES (57, 5, 90531, '1999-09-10', '2000-09-09');
INSERT INTO public.salario VALUES (58, 5, 91453, '2000-09-09', '2001-09-09');
INSERT INTO public.salario VALUES (59, 5, 94692, '2001-09-09', NULL);
INSERT INTO public.salario VALUES (60, 6, 40000, '1990-08-05', '1991-08-05');
INSERT INTO public.salario VALUES (61, 6, 42085, '1991-08-05', '1992-08-04');
INSERT INTO public.salario VALUES (62, 6, 42629, '1992-08-04', '1993-08-04');
INSERT INTO public.salario VALUES (63, 6, 45844, '1993-08-04', '1994-08-04');
INSERT INTO public.salario VALUES (64, 6, 47518, '1994-08-04', '1995-08-04');
INSERT INTO public.salario VALUES (65, 6, 47917, '1995-08-04', '1996-08-03');
INSERT INTO public.salario VALUES (66, 6, 52255, '1996-08-03', '1997-08-03');
INSERT INTO public.salario VALUES (67, 6, 53747, '1997-08-03', '1998-08-03');
INSERT INTO public.salario VALUES (68, 6, 56032, '1998-08-03', '1999-08-03');
INSERT INTO public.salario VALUES (69, 6, 58299, '1999-08-03', '2000-08-02');
INSERT INTO public.salario VALUES (70, 6, 60098, '2000-08-02', '2001-08-02');
INSERT INTO public.salario VALUES (71, 6, 59755, '2001-08-02', NULL);
INSERT INTO public.salario VALUES (72, 7, 56724, '1989-02-10', '1990-02-10');
INSERT INTO public.salario VALUES (73, 7, 60740, '1990-02-10', '1991-02-10');
INSERT INTO public.salario VALUES (74, 7, 62745, '1991-02-10', '1992-02-10');
INSERT INTO public.salario VALUES (75, 7, 63475, '1992-02-10', '1993-02-09');
INSERT INTO public.salario VALUES (76, 7, 63208, '1993-02-09', '1994-02-09');
INSERT INTO public.salario VALUES (77, 7, 64563, '1994-02-09', '1995-02-09');
INSERT INTO public.salario VALUES (78, 7, 68833, '1995-02-09', '1996-02-09');
INSERT INTO public.salario VALUES (79, 7, 70220, '1996-02-09', '1997-02-08');
INSERT INTO public.salario VALUES (80, 7, 73362, '1997-02-08', '1998-02-08');
INSERT INTO public.salario VALUES (81, 7, 75582, '1998-02-08', '1999-02-08');
INSERT INTO public.salario VALUES (82, 7, 79513, '1999-02-08', '2000-02-08');
INSERT INTO public.salario VALUES (83, 7, 80083, '2000-02-08', '2001-02-07');
INSERT INTO public.salario VALUES (84, 7, 84456, '2001-02-07', '2002-02-07');
INSERT INTO public.salario VALUES (85, 7, 88070, '2002-02-07', NULL);
INSERT INTO public.salario VALUES (86, 8, 46671, '1998-03-11', '1999-03-11');
INSERT INTO public.salario VALUES (87, 8, 48584, '1999-03-11', '2000-03-10');
INSERT INTO public.salario VALUES (88, 8, 52668, '2000-03-10', '2000-07-31');
INSERT INTO public.salario VALUES (89, 9, 60929, '1985-02-18', '1986-02-18');
INSERT INTO public.salario VALUES (90, 9, 64604, '1986-02-18', '1987-02-18');
INSERT INTO public.salario VALUES (91, 9, 64780, '1987-02-18', '1988-02-18');
INSERT INTO public.salario VALUES (92, 9, 66302, '1988-02-18', '1989-02-17');
INSERT INTO public.salario VALUES (93, 9, 69042, '1989-02-17', '1990-02-17');
INSERT INTO public.salario VALUES (94, 9, 70889, '1990-02-17', '1991-02-17');
INSERT INTO public.salario VALUES (95, 9, 71434, '1991-02-17', '1992-02-17');
INSERT INTO public.salario VALUES (96, 9, 74612, '1992-02-17', '1993-02-16');
INSERT INTO public.salario VALUES (97, 9, 76518, '1993-02-16', '1994-02-16');
INSERT INTO public.salario VALUES (98, 9, 78335, '1994-02-16', '1995-02-16');
INSERT INTO public.salario VALUES (99, 9, 80944, '1995-02-16', '1996-02-16');
INSERT INTO public.salario VALUES (100, 9, 82507, '1996-02-16', '1997-02-15');
INSERT INTO public.salario VALUES (101, 9, 85875, '1997-02-15', '1998-02-15');
INSERT INTO public.salario VALUES (102, 9, 89324, '1998-02-15', '1999-02-15');
INSERT INTO public.salario VALUES (103, 9, 90668, '1999-02-15', '2000-02-15');
INSERT INTO public.salario VALUES (104, 9, 93507, '2000-02-15', '2001-02-14');
INSERT INTO public.salario VALUES (105, 9, 94443, '2001-02-14', '2002-02-14');
INSERT INTO public.salario VALUES (106, 9, 94409, '2002-02-14', NULL);
INSERT INTO public.salario VALUES (107, 10, 72488, '1996-11-24', '1997-11-24');
INSERT INTO public.salario VALUES (108, 10, 74347, '1997-11-24', '1998-11-24');
INSERT INTO public.salario VALUES (109, 10, 75405, '1998-11-24', '1999-11-24');
INSERT INTO public.salario VALUES (110, 10, 78194, '1999-11-24', '2000-11-23');
INSERT INTO public.salario VALUES (111, 10, 79580, '2000-11-23', '2001-11-23');
INSERT INTO public.salario VALUES (112, 10, 80324, '2001-11-23', NULL);
INSERT INTO public.salario VALUES (113, 11, 42365, '1990-01-22', '1991-01-22');
INSERT INTO public.salario VALUES (114, 11, 44200, '1991-01-22', '1992-01-22');
INSERT INTO public.salario VALUES (115, 11, 48214, '1992-01-22', '1993-01-21');
INSERT INTO public.salario VALUES (116, 11, 50927, '1993-01-21', '1994-01-21');
INSERT INTO public.salario VALUES (117, 11, 51470, '1994-01-21', '1995-01-21');
INSERT INTO public.salario VALUES (118, 11, 54545, '1995-01-21', '1996-01-21');
INSERT INTO public.salario VALUES (119, 11, 56753, '1996-01-21', '1996-11-09');
INSERT INTO public.salario VALUES (120, 12, 40000, '1992-12-18', '1993-12-18');
INSERT INTO public.salario VALUES (121, 12, 41867, '1993-12-18', '1994-12-18');
INSERT INTO public.salario VALUES (122, 12, 42318, '1994-12-18', '1995-12-18');
INSERT INTO public.salario VALUES (123, 12, 44195, '1995-12-18', '1996-12-17');
INSERT INTO public.salario VALUES (124, 12, 46460, '1996-12-17', '1997-12-17');
INSERT INTO public.salario VALUES (125, 12, 46485, '1997-12-17', '1998-12-17');
INSERT INTO public.salario VALUES (126, 12, 47364, '1998-12-17', '1999-12-17');
INSERT INTO public.salario VALUES (127, 12, 51122, '1999-12-17', '2000-12-16');
INSERT INTO public.salario VALUES (128, 12, 54794, '2000-12-16', '2001-12-16');
INSERT INTO public.salario VALUES (129, 12, 54423, '2001-12-16', NULL);
INSERT INTO public.salario VALUES (130, 13, 40000, '1985-10-20', '1986-10-20');
INSERT INTO public.salario VALUES (131, 13, 40623, '1986-10-20', '1987-10-20');
INSERT INTO public.salario VALUES (132, 13, 40561, '1987-10-20', '1988-10-19');
INSERT INTO public.salario VALUES (133, 13, 40306, '1988-10-19', '1989-10-19');
INSERT INTO public.salario VALUES (134, 13, 43569, '1989-10-19', '1990-10-19');
INSERT INTO public.salario VALUES (135, 13, 46305, '1990-10-19', '1991-10-19');
INSERT INTO public.salario VALUES (136, 13, 47118, '1991-10-19', '1992-10-18');
INSERT INTO public.salario VALUES (137, 13, 50351, '1992-10-18', '1993-10-18');
INSERT INTO public.salario VALUES (138, 13, 49887, '1993-10-18', '1994-10-18');
INSERT INTO public.salario VALUES (139, 13, 53957, '1994-10-18', '1995-10-18');
INSERT INTO public.salario VALUES (140, 13, 57590, '1995-10-18', '1996-10-17');
INSERT INTO public.salario VALUES (141, 13, 59228, '1996-10-17', '1997-10-17');
INSERT INTO public.salario VALUES (142, 13, 59571, '1997-10-17', '1998-10-17');
INSERT INTO public.salario VALUES (143, 13, 63274, '1998-10-17', '1999-10-17');
INSERT INTO public.salario VALUES (144, 13, 63352, '1999-10-17', '2000-10-16');
INSERT INTO public.salario VALUES (145, 13, 66744, '2000-10-16', '2001-10-16');
INSERT INTO public.salario VALUES (146, 13, 68901, '2001-10-16', NULL);
INSERT INTO public.salario VALUES (147, 14, 46168, '1993-12-29', '1994-12-29');
INSERT INTO public.salario VALUES (148, 14, 48242, '1994-12-29', '1995-12-29');
INSERT INTO public.salario VALUES (149, 14, 47921, '1995-12-29', '1996-12-28');
INSERT INTO public.salario VALUES (150, 14, 50715, '1996-12-28', '1997-12-28');
INSERT INTO public.salario VALUES (151, 14, 53228, '1997-12-28', '1998-12-28');
INSERT INTO public.salario VALUES (152, 14, 53962, '1998-12-28', '1999-12-28');
INSERT INTO public.salario VALUES (153, 14, 56937, '1999-12-28', '2000-12-27');
INSERT INTO public.salario VALUES (154, 14, 59142, '2000-12-27', '2001-12-27');
INSERT INTO public.salario VALUES (155, 14, 60598, '2001-12-27', NULL);
INSERT INTO public.salario VALUES (156, 15, 40000, '1992-09-19', '1993-08-22');
INSERT INTO public.salario VALUES (157, 16, 70889, '1998-02-11', '1999-02-11');
INSERT INTO public.salario VALUES (158, 16, 72946, '1999-02-11', '2000-02-11');
INSERT INTO public.salario VALUES (159, 16, 76826, '2000-02-11', '2001-02-10');
INSERT INTO public.salario VALUES (160, 16, 76381, '2001-02-10', '2002-02-10');
INSERT INTO public.salario VALUES (161, 16, 77935, '2002-02-10', NULL);
INSERT INTO public.salario VALUES (162, 17, 71380, '1993-08-03', '1994-08-03');
INSERT INTO public.salario VALUES (163, 17, 75538, '1994-08-03', '1995-08-03');
INSERT INTO public.salario VALUES (164, 17, 79510, '1995-08-03', '1996-08-02');
INSERT INTO public.salario VALUES (165, 17, 82163, '1996-08-02', '1997-08-02');
INSERT INTO public.salario VALUES (166, 17, 86157, '1997-08-02', '1998-08-02');
INSERT INTO public.salario VALUES (167, 17, 89619, '1998-08-02', '1999-08-02');
INSERT INTO public.salario VALUES (168, 17, 91985, '1999-08-02', '2000-08-01');
INSERT INTO public.salario VALUES (169, 17, 96122, '2000-08-01', '2001-08-01');
INSERT INTO public.salario VALUES (170, 17, 98522, '2001-08-01', '2002-08-01');
INSERT INTO public.salario VALUES (171, 17, 99651, '2002-08-01', NULL);
INSERT INTO public.salario VALUES (172, 18, 55881, '1987-04-03', '1988-04-02');
INSERT INTO public.salario VALUES (173, 18, 59206, '1988-04-02', '1989-04-02');
INSERT INTO public.salario VALUES (174, 18, 61361, '1989-04-02', '1990-04-02');
INSERT INTO public.salario VALUES (175, 18, 61648, '1990-04-02', '1991-04-02');
INSERT INTO public.salario VALUES (176, 18, 61217, '1991-04-02', '1992-04-01');
INSERT INTO public.salario VALUES (177, 18, 61244, '1992-04-01', '1993-04-01');
INSERT INTO public.salario VALUES (178, 18, 63286, '1993-04-01', '1994-04-01');
INSERT INTO public.salario VALUES (179, 18, 65739, '1994-04-01', '1995-04-01');
INSERT INTO public.salario VALUES (180, 18, 67519, '1995-04-01', '1996-03-31');
INSERT INTO public.salario VALUES (181, 18, 69276, '1996-03-31', '1997-03-31');
INSERT INTO public.salario VALUES (182, 18, 72585, '1997-03-31', '1998-03-31');
INSERT INTO public.salario VALUES (183, 18, 72804, '1998-03-31', '1999-03-31');
INSERT INTO public.salario VALUES (184, 18, 76957, '1999-03-31', '2000-03-30');
INSERT INTO public.salario VALUES (185, 18, 80305, '2000-03-30', '2001-03-30');
INSERT INTO public.salario VALUES (186, 18, 84541, '2001-03-30', '2002-03-30');
INSERT INTO public.salario VALUES (187, 18, 84672, '2002-03-30', NULL);
INSERT INTO public.salario VALUES (188, 19, 44276, '1999-04-30', '2000-04-29');
INSERT INTO public.salario VALUES (189, 19, 46946, '2000-04-29', '2001-04-29');
INSERT INTO public.salario VALUES (190, 19, 46775, '2001-04-29', '2002-04-29');
INSERT INTO public.salario VALUES (191, 19, 50032, '2002-04-29', NULL);
INSERT INTO public.salario VALUES (192, 20, 40000, '1997-12-30', '1998-12-30');
INSERT INTO public.salario VALUES (193, 20, 40647, '1998-12-30', '1999-12-30');
INSERT INTO public.salario VALUES (194, 20, 43800, '1999-12-30', '2000-12-29');
INSERT INTO public.salario VALUES (195, 20, 44927, '2000-12-29', '2001-12-29');
INSERT INTO public.salario VALUES (196, 20, 47017, '2001-12-29', NULL);
INSERT INTO public.salario VALUES (197, 21, 55025, '1988-02-10', '1989-02-09');
INSERT INTO public.salario VALUES (198, 21, 56399, '1989-02-09', '1990-02-09');
INSERT INTO public.salario VALUES (199, 21, 59700, '1990-02-09', '1991-02-09');
INSERT INTO public.salario VALUES (200, 21, 60851, '1991-02-09', '1992-02-09');
INSERT INTO public.salario VALUES (201, 21, 61117, '1992-02-09', '1993-02-08');
INSERT INTO public.salario VALUES (202, 21, 60708, '1993-02-08', '1994-02-08');
INSERT INTO public.salario VALUES (203, 21, 63514, '1994-02-08', '1995-02-08');
INSERT INTO public.salario VALUES (204, 21, 66249, '1995-02-08', '1996-02-08');
INSERT INTO public.salario VALUES (205, 21, 70570, '1996-02-08', '1997-02-07');
INSERT INTO public.salario VALUES (206, 21, 74759, '1997-02-07', '1998-02-07');
INSERT INTO public.salario VALUES (207, 21, 77519, '1998-02-07', '1999-02-07');
INSERT INTO public.salario VALUES (208, 21, 77237, '1999-02-07', '2000-02-07');
INSERT INTO public.salario VALUES (209, 21, 79631, '2000-02-07', '2001-02-06');
INSERT INTO public.salario VALUES (210, 21, 82295, '2001-02-06', '2002-02-06');
INSERT INTO public.salario VALUES (211, 21, 84169, '2002-02-06', '2002-07-15');
INSERT INTO public.salario VALUES (212, 22, 40000, '1999-09-03', '2000-09-02');
INSERT INTO public.salario VALUES (213, 22, 39935, '2000-09-02', '2001-09-02');
INSERT INTO public.salario VALUES (214, 22, 41348, '2001-09-02', NULL);
INSERT INTO public.salario VALUES (215, 23, 47883, '1999-09-27', '2000-09-26');
INSERT INTO public.salario VALUES (216, 23, 50319, '2000-09-26', '2001-09-26');
INSERT INTO public.salario VALUES (217, 23, 50113, '2001-09-26', NULL);
INSERT INTO public.salario VALUES (218, 24, 83733, '1998-06-14', '1999-06-14');
INSERT INTO public.salario VALUES (219, 24, 86715, '1999-06-14', '2000-06-13');
INSERT INTO public.salario VALUES (220, 24, 91067, '2000-06-13', '2001-06-13');
INSERT INTO public.salario VALUES (221, 24, 94701, '2001-06-13', '2002-06-13');
INSERT INTO public.salario VALUES (222, 24, 96646, '2002-06-13', NULL);
INSERT INTO public.salario VALUES (223, 25, 40000, '1987-08-17', '1988-08-16');
INSERT INTO public.salario VALUES (224, 25, 44416, '1988-08-16', '1989-08-16');
INSERT INTO public.salario VALUES (225, 25, 48680, '1989-08-16', '1990-08-16');
INSERT INTO public.salario VALUES (226, 25, 50120, '1990-08-16', '1991-08-16');
INSERT INTO public.salario VALUES (227, 25, 50980, '1991-08-16', '1992-08-15');
INSERT INTO public.salario VALUES (228, 25, 54459, '1992-08-15', '1993-08-15');
INSERT INTO public.salario VALUES (229, 25, 54395, '1993-08-15', '1994-08-15');
INSERT INTO public.salario VALUES (230, 25, 56643, '1994-08-15', '1995-08-15');
INSERT INTO public.salario VALUES (231, 25, 57585, '1995-08-15', '1996-08-14');
INSERT INTO public.salario VALUES (232, 25, 57110, '1996-08-14', '1997-08-14');
INSERT INTO public.salario VALUES (233, 25, 57157, '1997-08-14', '1997-10-15');
INSERT INTO public.salario VALUES (234, 26, 47585, '1995-03-20', '1996-03-19');
INSERT INTO public.salario VALUES (235, 26, 51730, '1996-03-19', '1997-03-19');
INSERT INTO public.salario VALUES (236, 26, 53682, '1997-03-19', '1998-03-19');
INSERT INTO public.salario VALUES (237, 26, 56769, '1998-03-19', '1999-03-19');
INSERT INTO public.salario VALUES (238, 26, 60397, '1999-03-19', '2000-03-18');
INSERT INTO public.salario VALUES (239, 26, 64132, '2000-03-18', '2001-03-18');
INSERT INTO public.salario VALUES (240, 26, 65415, '2001-03-18', '2002-03-18');
INSERT INTO public.salario VALUES (241, 26, 66313, '2002-03-18', NULL);
INSERT INTO public.salario VALUES (242, 27, 40000, '1995-04-02', '1996-04-01');
INSERT INTO public.salario VALUES (243, 27, 39520, '1996-04-01', '1997-04-01');
INSERT INTO public.salario VALUES (244, 27, 42382, '1997-04-01', '1998-04-01');
INSERT INTO public.salario VALUES (245, 27, 43654, '1998-04-01', '1999-04-01');
INSERT INTO public.salario VALUES (246, 27, 43925, '1999-04-01', '2000-03-31');
INSERT INTO public.salario VALUES (247, 27, 45157, '2000-03-31', '2001-03-31');
INSERT INTO public.salario VALUES (248, 27, 45771, '2001-03-31', '2002-03-31');
INSERT INTO public.salario VALUES (249, 27, 46145, '2002-03-31', NULL);
INSERT INTO public.salario VALUES (250, 28, 48859, '1991-10-22', '1992-10-21');
INSERT INTO public.salario VALUES (251, 28, 50805, '1992-10-21', '1993-10-21');
INSERT INTO public.salario VALUES (252, 28, 52082, '1993-10-21', '1994-10-21');
INSERT INTO public.salario VALUES (253, 28, 54949, '1994-10-21', '1995-10-21');
INSERT INTO public.salario VALUES (254, 28, 55963, '1995-10-21', '1996-10-20');
INSERT INTO public.salario VALUES (255, 28, 57831, '1996-10-20', '1997-10-20');
INSERT INTO public.salario VALUES (256, 28, 58502, '1997-10-20', '1998-04-06');
INSERT INTO public.salario VALUES (257, 29, 63163, '1991-09-18', '1992-09-17');
INSERT INTO public.salario VALUES (258, 29, 66877, '1992-09-17', '1993-09-17');
INSERT INTO public.salario VALUES (259, 29, 69211, '1993-09-17', '1994-09-17');
INSERT INTO public.salario VALUES (260, 29, 70624, '1994-09-17', '1995-09-17');
INSERT INTO public.salario VALUES (261, 29, 70294, '1995-09-17', '1996-09-16');
INSERT INTO public.salario VALUES (262, 29, 70671, '1996-09-16', '1997-09-16');
INSERT INTO public.salario VALUES (263, 29, 73510, '1997-09-16', '1998-09-16');
INSERT INTO public.salario VALUES (264, 29, 75773, '1998-09-16', '1999-09-16');
INSERT INTO public.salario VALUES (265, 29, 76067, '1999-09-16', '2000-09-15');
INSERT INTO public.salario VALUES (266, 29, 76608, '2000-09-15', '2001-09-15');
INSERT INTO public.salario VALUES (267, 29, 77777, '2001-09-15', NULL);
INSERT INTO public.salario VALUES (268, 30, 66956, '1994-02-17', '1995-02-17');
INSERT INTO public.salario VALUES (269, 30, 68393, '1995-02-17', '1996-02-17');
INSERT INTO public.salario VALUES (270, 30, 72795, '1996-02-17', '1997-02-16');
INSERT INTO public.salario VALUES (271, 30, 76453, '1997-02-16', '1998-02-16');
INSERT INTO public.salario VALUES (272, 30, 79290, '1998-02-16', '1999-02-16');
INSERT INTO public.salario VALUES (273, 30, 83327, '1999-02-16', '2000-02-16');
INSERT INTO public.salario VALUES (274, 30, 86634, '2000-02-16', '2001-02-15');
INSERT INTO public.salario VALUES (275, 30, 87027, '2001-02-15', '2002-02-15');
INSERT INTO public.salario VALUES (276, 30, 88806, '2002-02-15', NULL);
INSERT INTO public.salario VALUES (277, 31, 40000, '1991-09-01', '1992-08-31');
INSERT INTO public.salario VALUES (278, 31, 40859, '1992-08-31', '1993-08-31');
INSERT INTO public.salario VALUES (279, 31, 41881, '1993-08-31', '1994-08-31');
INSERT INTO public.salario VALUES (280, 31, 44191, '1994-08-31', '1995-08-31');
INSERT INTO public.salario VALUES (281, 31, 47202, '1995-08-31', '1996-08-30');
INSERT INTO public.salario VALUES (282, 31, 47606, '1996-08-30', '1997-08-30');
INSERT INTO public.salario VALUES (283, 31, 50810, '1997-08-30', '1998-08-30');
INSERT INTO public.salario VALUES (284, 31, 52675, '1998-08-30', '1999-08-30');
INSERT INTO public.salario VALUES (285, 31, 54177, '1999-08-30', '2000-08-29');
INSERT INTO public.salario VALUES (286, 31, 53873, '2000-08-29', '2001-08-29');
INSERT INTO public.salario VALUES (287, 31, 56689, '2001-08-29', NULL);
INSERT INTO public.salario VALUES (288, 32, 48426, '1990-06-20', '1991-06-20');
INSERT INTO public.salario VALUES (289, 32, 49389, '1991-06-20', '1992-06-19');
INSERT INTO public.salario VALUES (290, 32, 52000, '1992-06-19', '1993-06-19');
INSERT INTO public.salario VALUES (291, 32, 53038, '1993-06-19', '1994-06-19');
INSERT INTO public.salario VALUES (292, 32, 54336, '1994-06-19', '1995-06-19');
INSERT INTO public.salario VALUES (293, 32, 53978, '1995-06-19', '1996-06-18');
INSERT INTO public.salario VALUES (294, 32, 55090, '1996-06-18', '1997-06-18');
INSERT INTO public.salario VALUES (295, 32, 57110, '1997-06-18', '1998-06-18');
INSERT INTO public.salario VALUES (296, 32, 57926, '1998-06-18', '1999-06-18');
INSERT INTO public.salario VALUES (297, 32, 57876, '1999-06-18', '2000-06-17');
INSERT INTO public.salario VALUES (298, 32, 61709, '2000-06-17', '2001-06-17');
INSERT INTO public.salario VALUES (299, 32, 65820, '2001-06-17', '2002-06-17');
INSERT INTO public.salario VALUES (300, 32, 69539, '2002-06-17', NULL);
INSERT INTO public.salario VALUES (301, 33, 51258, '1987-03-18', '1988-03-17');
INSERT INTO public.salario VALUES (302, 33, 54972, '1988-03-17', '1989-03-17');
INSERT INTO public.salario VALUES (303, 33, 55410, '1989-03-17', '1990-03-17');
INSERT INTO public.salario VALUES (304, 33, 56095, '1990-03-17', '1991-03-17');
INSERT INTO public.salario VALUES (305, 33, 56038, '1991-03-17', '1992-03-16');
INSERT INTO public.salario VALUES (306, 33, 57712, '1992-03-16', '1993-03-16');
INSERT INTO public.salario VALUES (307, 33, 60433, '1993-03-16', '1993-03-24');
INSERT INTO public.salario VALUES (308, 34, 47561, '1995-04-12', '1996-04-11');
INSERT INTO public.salario VALUES (309, 34, 51192, '1996-04-11', '1997-04-11');
INSERT INTO public.salario VALUES (310, 34, 52687, '1997-04-11', '1998-04-11');
INSERT INTO public.salario VALUES (311, 34, 53112, '1998-04-11', '1999-04-11');
INSERT INTO public.salario VALUES (312, 34, 53164, '1999-04-11', '1999-10-31');
INSERT INTO public.salario VALUES (313, 35, 41538, '1988-09-05', '1989-09-05');
INSERT INTO public.salario VALUES (314, 35, 45131, '1989-09-05', '1990-09-05');
INSERT INTO public.salario VALUES (315, 35, 45629, '1990-09-05', '1991-09-05');
INSERT INTO public.salario VALUES (316, 35, 48360, '1991-09-05', '1992-09-04');
INSERT INTO public.salario VALUES (317, 35, 50664, '1992-09-04', '1993-09-04');
INSERT INTO public.salario VALUES (318, 35, 53060, '1993-09-04', '1994-09-04');
INSERT INTO public.salario VALUES (319, 35, 56640, '1994-09-04', '1995-09-04');
INSERT INTO public.salario VALUES (320, 35, 57621, '1995-09-04', '1996-09-03');
INSERT INTO public.salario VALUES (321, 35, 59291, '1996-09-03', '1997-09-03');
INSERT INTO public.salario VALUES (322, 35, 61793, '1997-09-03', '1998-09-03');
INSERT INTO public.salario VALUES (323, 35, 62285, '1998-09-03', '1999-09-03');
INSERT INTO public.salario VALUES (324, 35, 65332, '1999-09-03', '2000-09-02');
INSERT INTO public.salario VALUES (325, 35, 66584, '2000-09-02', '2001-09-02');
INSERT INTO public.salario VALUES (326, 35, 68755, '2001-09-02', NULL);
INSERT INTO public.salario VALUES (327, 36, 42819, '1992-04-28', '1993-04-28');
INSERT INTO public.salario VALUES (328, 36, 46756, '1993-04-28', '1994-04-28');
INSERT INTO public.salario VALUES (329, 36, 51084, '1994-04-28', '1995-04-28');
INSERT INTO public.salario VALUES (330, 36, 52308, '1995-04-28', '1996-04-27');
INSERT INTO public.salario VALUES (331, 36, 53828, '1996-04-27', '1997-04-27');
INSERT INTO public.salario VALUES (332, 36, 54408, '1997-04-27', '1998-04-27');
INSERT INTO public.salario VALUES (333, 36, 53929, '1998-04-27', '1999-04-27');
INSERT INTO public.salario VALUES (334, 36, 56579, '1999-04-27', '2000-04-26');
INSERT INTO public.salario VALUES (335, 36, 60478, '2000-04-26', '2001-04-26');
INSERT INTO public.salario VALUES (336, 36, 60520, '2001-04-26', '2002-04-26');
INSERT INTO public.salario VALUES (337, 36, 63053, '2002-04-26', NULL);
INSERT INTO public.salario VALUES (338, 37, 40000, '1990-12-05', '1991-12-05');
INSERT INTO public.salario VALUES (339, 37, 39765, '1991-12-05', '1992-12-04');
INSERT INTO public.salario VALUES (340, 37, 43565, '1992-12-04', '1993-12-04');
INSERT INTO public.salario VALUES (341, 37, 43104, '1993-12-04', '1994-12-04');
INSERT INTO public.salario VALUES (342, 37, 46100, '1994-12-04', '1995-12-04');
INSERT INTO public.salario VALUES (343, 37, 49735, '1995-12-04', '1996-12-03');
INSERT INTO public.salario VALUES (344, 37, 51775, '1996-12-03', '1997-12-03');
INSERT INTO public.salario VALUES (345, 37, 53198, '1997-12-03', '1998-12-03');
INSERT INTO public.salario VALUES (346, 37, 56270, '1998-12-03', '1999-12-03');
INSERT INTO public.salario VALUES (347, 37, 59882, '1999-12-03', '2000-12-02');
INSERT INTO public.salario VALUES (348, 37, 60992, '2000-12-02', '2001-12-02');
INSERT INTO public.salario VALUES (349, 37, 60574, '2001-12-02', NULL);
INSERT INTO public.salario VALUES (350, 38, 40000, '1989-09-20', '1990-09-20');
INSERT INTO public.salario VALUES (351, 38, 43527, '1990-09-20', '1991-09-20');
INSERT INTO public.salario VALUES (352, 38, 46509, '1991-09-20', '1992-09-19');
INSERT INTO public.salario VALUES (353, 38, 49874, '1992-09-19', '1993-09-19');
INSERT INTO public.salario VALUES (354, 38, 52969, '1993-09-19', '1994-09-19');
INSERT INTO public.salario VALUES (355, 38, 56629, '1994-09-19', '1995-09-19');
INSERT INTO public.salario VALUES (356, 38, 58079, '1995-09-19', '1996-09-18');
INSERT INTO public.salario VALUES (357, 38, 60322, '1996-09-18', '1997-09-18');
INSERT INTO public.salario VALUES (358, 38, 62274, '1997-09-18', '1998-09-18');
INSERT INTO public.salario VALUES (359, 38, 62517, '1998-09-18', '1999-09-18');
INSERT INTO public.salario VALUES (360, 38, 62458, '1999-09-18', '2000-09-17');
INSERT INTO public.salario VALUES (361, 38, 64238, '2000-09-17', '2001-09-17');
INSERT INTO public.salario VALUES (362, 38, 64254, '2001-09-17', NULL);
INSERT INTO public.salario VALUES (363, 39, 40000, '1988-01-19', '1989-01-18');
INSERT INTO public.salario VALUES (364, 39, 41525, '1989-01-18', '1990-01-18');
INSERT INTO public.salario VALUES (365, 39, 43801, '1990-01-18', '1991-01-18');
INSERT INTO public.salario VALUES (366, 39, 46278, '1991-01-18', '1992-01-18');
INSERT INTO public.salario VALUES (367, 39, 45838, '1992-01-18', '1993-01-17');
INSERT INTO public.salario VALUES (368, 39, 49155, '1993-01-17', '1994-01-17');
INSERT INTO public.salario VALUES (369, 39, 52999, '1994-01-17', '1995-01-17');
INSERT INTO public.salario VALUES (370, 39, 55037, '1995-01-17', '1996-01-17');
INSERT INTO public.salario VALUES (371, 39, 54937, '1996-01-17', '1997-01-16');
INSERT INTO public.salario VALUES (372, 39, 55204, '1997-01-16', '1998-01-16');
INSERT INTO public.salario VALUES (373, 39, 59593, '1998-01-16', '1999-01-16');
INSERT INTO public.salario VALUES (374, 39, 62131, '1999-01-16', '2000-01-16');
INSERT INTO public.salario VALUES (375, 39, 61774, '2000-01-16', '2001-01-15');
INSERT INTO public.salario VALUES (376, 39, 63592, '2001-01-15', '2002-01-15');
INSERT INTO public.salario VALUES (377, 39, 63918, '2002-01-15', NULL);
INSERT INTO public.salario VALUES (378, 40, 52153, '1993-02-14', '1994-02-14');
INSERT INTO public.salario VALUES (379, 40, 53533, '1994-02-14', '1995-02-14');
INSERT INTO public.salario VALUES (380, 40, 56565, '1995-02-14', '1996-02-14');
INSERT INTO public.salario VALUES (381, 40, 60260, '1996-02-14', '1997-02-13');
INSERT INTO public.salario VALUES (382, 40, 62101, '1997-02-13', '1998-02-13');
INSERT INTO public.salario VALUES (383, 40, 63870, '1998-02-13', '1999-02-13');
INSERT INTO public.salario VALUES (384, 40, 64570, '1999-02-13', '2000-02-13');
INSERT INTO public.salario VALUES (385, 40, 67016, '2000-02-13', '2001-02-12');
INSERT INTO public.salario VALUES (386, 40, 68185, '2001-02-12', '2002-02-12');
INSERT INTO public.salario VALUES (387, 40, 72668, '2002-02-12', NULL);
INSERT INTO public.salario VALUES (388, 41, 56893, '1989-11-12', '1990-11-12');
INSERT INTO public.salario VALUES (389, 41, 60824, '1990-11-12', '1991-11-12');
INSERT INTO public.salario VALUES (390, 41, 63116, '1991-11-12', '1992-11-11');
INSERT INTO public.salario VALUES (391, 41, 64128, '1992-11-11', '1993-11-11');
INSERT INTO public.salario VALUES (392, 41, 65615, '1993-11-11', '1994-11-11');
INSERT INTO public.salario VALUES (393, 41, 69768, '1994-11-11', '1995-11-11');
INSERT INTO public.salario VALUES (394, 41, 70216, '1995-11-11', '1996-11-10');
INSERT INTO public.salario VALUES (395, 41, 71322, '1996-11-10', '1997-11-10');
INSERT INTO public.salario VALUES (396, 41, 74575, '1997-11-10', '1998-11-10');
INSERT INTO public.salario VALUES (397, 41, 75544, '1998-11-10', '1999-11-10');
INSERT INTO public.salario VALUES (398, 41, 79746, '1999-11-10', '2000-11-09');
INSERT INTO public.salario VALUES (399, 41, 81012, '2000-11-09', '2001-11-09');
INSERT INTO public.salario VALUES (400, 41, 81705, '2001-11-09', NULL);
INSERT INTO public.salario VALUES (401, 42, 81662, '1993-03-21', '1994-03-21');
INSERT INTO public.salario VALUES (402, 42, 84183, '1994-03-21', '1995-03-21');
INSERT INTO public.salario VALUES (403, 42, 84389, '1995-03-21', '1996-03-20');
INSERT INTO public.salario VALUES (404, 42, 85501, '1996-03-20', '1997-03-20');
INSERT INTO public.salario VALUES (405, 42, 89833, '1997-03-20', '1998-03-20');
INSERT INTO public.salario VALUES (406, 42, 91161, '1998-03-20', '1999-03-20');
INSERT INTO public.salario VALUES (407, 42, 95035, '1999-03-20', '2000-03-19');
INSERT INTO public.salario VALUES (408, 42, 94868, '2000-03-19', '2000-08-10');
INSERT INTO public.salario VALUES (409, 43, 49324, '1990-10-20', '1991-10-20');
INSERT INTO public.salario VALUES (410, 43, 51948, '1991-10-20', '1992-10-19');
INSERT INTO public.salario VALUES (411, 43, 54011, '1992-10-19', '1993-10-19');
INSERT INTO public.salario VALUES (412, 43, 58302, '1993-10-19', '1994-10-19');
INSERT INTO public.salario VALUES (413, 43, 62291, '1994-10-19', '1995-10-19');
INSERT INTO public.salario VALUES (414, 43, 65669, '1995-10-19', '1996-10-18');
INSERT INTO public.salario VALUES (415, 43, 65562, '1996-10-18', '1997-10-18');
INSERT INTO public.salario VALUES (416, 43, 68328, '1997-10-18', '1998-10-18');
INSERT INTO public.salario VALUES (417, 43, 70689, '1998-10-18', '1999-10-18');
INSERT INTO public.salario VALUES (418, 43, 72543, '1999-10-18', '2000-10-17');
INSERT INTO public.salario VALUES (419, 43, 76677, '2000-10-17', '2001-10-17');
INSERT INTO public.salario VALUES (420, 43, 77659, '2001-10-17', NULL);
INSERT INTO public.salario VALUES (421, 44, 40919, '1994-05-21', '1995-05-21');
INSERT INTO public.salario VALUES (422, 44, 45217, '1995-05-21', '1996-05-20');
INSERT INTO public.salario VALUES (423, 44, 46674, '1996-05-20', '1997-05-20');
INSERT INTO public.salario VALUES (424, 44, 48623, '1997-05-20', '1998-05-20');
INSERT INTO public.salario VALUES (425, 44, 51377, '1998-05-20', '1999-05-20');
INSERT INTO public.salario VALUES (426, 44, 53186, '1999-05-20', '2000-05-19');
INSERT INTO public.salario VALUES (427, 44, 56058, '2000-05-19', '2001-05-19');
INSERT INTO public.salario VALUES (428, 44, 56810, '2001-05-19', '2002-05-19');
INSERT INTO public.salario VALUES (429, 44, 58345, '2002-05-19', NULL);
INSERT INTO public.salario VALUES (430, 45, 41971, '1996-11-16', '1997-11-16');
INSERT INTO public.salario VALUES (431, 45, 42914, '1997-11-16', '1998-11-16');
INSERT INTO public.salario VALUES (432, 45, 43046, '1998-11-16', '1999-11-16');
INSERT INTO public.salario VALUES (433, 45, 43838, '1999-11-16', '2000-11-15');
INSERT INTO public.salario VALUES (434, 45, 47984, '2000-11-15', '2001-11-15');
INSERT INTO public.salario VALUES (435, 45, 47581, '2001-11-15', NULL);
INSERT INTO public.salario VALUES (436, 46, 40000, '1992-06-20', '1993-06-20');
INSERT INTO public.salario VALUES (437, 46, 42385, '1993-06-20', '1994-06-20');
INSERT INTO public.salario VALUES (438, 46, 43485, '1994-06-20', '1995-06-20');
INSERT INTO public.salario VALUES (439, 46, 43203, '1995-06-20', '1996-06-19');
INSERT INTO public.salario VALUES (440, 46, 45150, '1996-06-19', '1997-06-19');
INSERT INTO public.salario VALUES (441, 46, 48222, '1997-06-19', '1998-06-19');
INSERT INTO public.salario VALUES (442, 46, 50853, '1998-06-19', '1999-06-19');
INSERT INTO public.salario VALUES (443, 46, 52271, '1999-06-19', '2000-06-18');
INSERT INTO public.salario VALUES (444, 46, 56481, '2000-06-18', '2001-06-18');
INSERT INTO public.salario VALUES (445, 46, 60249, '2001-06-18', '2002-06-18');
INSERT INTO public.salario VALUES (446, 46, 62218, '2002-06-18', NULL);
INSERT INTO public.salario VALUES (447, 47, 54982, '1989-03-31', '1990-03-31');
INSERT INTO public.salario VALUES (448, 47, 57350, '1990-03-31', '1991-03-31');
INSERT INTO public.salario VALUES (449, 47, 59571, '1991-03-31', '1992-03-30');
INSERT INTO public.salario VALUES (450, 47, 62851, '1992-03-30', '1993-03-30');
INSERT INTO public.salario VALUES (451, 47, 65225, '1993-03-30', '1994-03-30');
INSERT INTO public.salario VALUES (452, 47, 66330, '1994-03-30', '1995-03-30');
INSERT INTO public.salario VALUES (453, 47, 69992, '1995-03-30', '1996-03-29');
INSERT INTO public.salario VALUES (454, 47, 73376, '1996-03-29', '1997-03-29');
INSERT INTO public.salario VALUES (455, 47, 74735, '1997-03-29', '1998-03-29');
INSERT INTO public.salario VALUES (456, 47, 75748, '1998-03-29', '1999-03-29');
INSERT INTO public.salario VALUES (457, 47, 77149, '1999-03-29', '2000-03-28');
INSERT INTO public.salario VALUES (458, 47, 78399, '2000-03-28', '2001-03-28');
INSERT INTO public.salario VALUES (459, 47, 78569, '2001-03-28', '2002-03-28');
INSERT INTO public.salario VALUES (460, 47, 81037, '2002-03-28', NULL);
INSERT INTO public.salario VALUES (461, 48, 40000, '1985-02-24', '1986-02-24');
INSERT INTO public.salario VALUES (462, 48, 39507, '1986-02-24', '1987-01-27');
INSERT INTO public.salario VALUES (463, 49, 40000, '1992-05-04', '1993-05-04');
INSERT INTO public.salario VALUES (464, 49, 39735, '1993-05-04', '1994-05-04');
INSERT INTO public.salario VALUES (465, 49, 40484, '1994-05-04', '1995-05-04');
INSERT INTO public.salario VALUES (466, 49, 41291, '1995-05-04', '1996-05-03');
INSERT INTO public.salario VALUES (467, 49, 41301, '1996-05-03', '1997-05-03');
INSERT INTO public.salario VALUES (468, 49, 41957, '1997-05-03', '1998-05-03');
INSERT INTO public.salario VALUES (469, 49, 41788, '1998-05-03', '1999-05-03');
INSERT INTO public.salario VALUES (470, 49, 44620, '1999-05-03', '2000-05-02');
INSERT INTO public.salario VALUES (471, 49, 45933, '2000-05-02', '2001-05-02');
INSERT INTO public.salario VALUES (472, 49, 48575, '2001-05-02', '2002-05-02');
INSERT INTO public.salario VALUES (473, 49, 51326, '2002-05-02', NULL);
INSERT INTO public.salario VALUES (474, 50, 74366, '1990-12-25', '1991-12-25');
INSERT INTO public.salario VALUES (475, 50, 78675, '1991-12-25', '1992-12-24');
INSERT INTO public.salario VALUES (476, 50, 82220, '1992-12-24', '1993-12-24');
INSERT INTO public.salario VALUES (477, 50, 86604, '1993-12-24', '1994-12-24');
INSERT INTO public.salario VALUES (478, 50, 88087, '1994-12-24', '1995-12-24');
INSERT INTO public.salario VALUES (479, 50, 88836, '1995-12-24', '1996-12-23');
INSERT INTO public.salario VALUES (480, 50, 90623, '1996-12-23', '1997-12-23');
INSERT INTO public.salario VALUES (481, 50, 91530, '1997-12-23', '1998-12-23');
INSERT INTO public.salario VALUES (482, 50, 93689, '1998-12-23', '1999-12-23');
INSERT INTO public.salario VALUES (483, 50, 97571, '1999-12-23', '2000-12-22');
INSERT INTO public.salario VALUES (484, 50, 97817, '2000-12-22', '2001-12-22');
INSERT INTO public.salario VALUES (485, 50, 97830, '2001-12-22', NULL);


--
-- TOC entry 3184 (class 2606 OID 32824)
-- Name: depart_func depart_func_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.depart_func
    ADD CONSTRAINT depart_func_pk PRIMARY KEY (id_depart_func);


--
-- TOC entry 3176 (class 2606 OID 32799)
-- Name: departamento departamento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pk PRIMARY KEY (id_departamento);


--
-- TOC entry 3178 (class 2606 OID 32801)
-- Name: departamento departamento_un; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_un UNIQUE (nome);


--
-- TOC entry 3180 (class 2606 OID 32809)
-- Name: funcionario funcionario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pk PRIMARY KEY (id_funcionario);


--
-- TOC entry 3187 (class 2606 OID 32831)
-- Name: salario salario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salario
    ADD CONSTRAINT salario_pk PRIMARY KEY (id_salario);


--
-- TOC entry 3181 (class 1259 OID 32838)
-- Name: depart_func_fk_departamento_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX depart_func_fk_departamento_idx ON public.depart_func USING btree (fk_departamento);


--
-- TOC entry 3182 (class 1259 OID 32839)
-- Name: depart_func_fk_funcionario_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX depart_func_fk_funcionario_idx ON public.depart_func USING btree (fk_funcionario);


--
-- TOC entry 3185 (class 1259 OID 32840)
-- Name: salario_fk_funcionario_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX salario_fk_funcionario_idx ON public.salario USING btree (fk_funcionario);


--
-- TOC entry 3188 (class 2606 OID 32813)
-- Name: depart_func depart_func_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.depart_func
    ADD CONSTRAINT depart_func_fk FOREIGN KEY (fk_departamento) REFERENCES public.departamento(id_departamento) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3189 (class 2606 OID 32818)
-- Name: depart_func depart_func_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.depart_func
    ADD CONSTRAINT depart_func_fk_1 FOREIGN KEY (fk_funcionario) REFERENCES public.funcionario(id_funcionario) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3190 (class 2606 OID 32832)
-- Name: salario salario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.salario
    ADD CONSTRAINT salario_fk FOREIGN KEY (fk_funcionario) REFERENCES public.funcionario(id_funcionario) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2022-08-18 08:32:24

--
-- PostgreSQL database dump complete
--

