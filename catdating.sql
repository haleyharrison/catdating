--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: females; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE females (
    id integer NOT NULL,
    name character varying,
    fixed character varying,
    city character varying,
    breed character varying
);


ALTER TABLE females OWNER TO "Guest";

--
-- Name: females_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE females_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE females_id_seq OWNER TO "Guest";

--
-- Name: females_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE females_id_seq OWNED BY females.id;


--
-- Name: males; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE males (
    id integer NOT NULL,
    name character varying,
    fixed character varying,
    city character varying,
    breed character varying
);


ALTER TABLE males OWNER TO "Guest";

--
-- Name: males_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE males_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE males_id_seq OWNER TO "Guest";

--
-- Name: males_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE males_id_seq OWNED BY males.id;


--
-- Name: matches; Type: TABLE; Schema: public; Owner: Guest; Tablespace: 
--

CREATE TABLE matches (
    id integer NOT NULL,
    male_id integer,
    female_id integer
);


ALTER TABLE matches OWNER TO "Guest";

--
-- Name: matches_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE matches_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE matches_id_seq OWNER TO "Guest";

--
-- Name: matches_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE matches_id_seq OWNED BY matches.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY females ALTER COLUMN id SET DEFAULT nextval('females_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY males ALTER COLUMN id SET DEFAULT nextval('males_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY matches ALTER COLUMN id SET DEFAULT nextval('matches_id_seq'::regclass);


--
-- Data for Name: females; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY females (id, name, fixed, city, breed) FROM stdin;
1	cat	y	pdx	\N
2	cat	yes	pdx	\N
3	She	n	la	\N
\.


--
-- Name: females_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('females_id_seq', 3, true);


--
-- Data for Name: males; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY males (id, name, fixed, city, breed) FROM stdin;
1	cat	no	pdx	\N
\.


--
-- Name: males_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('males_id_seq', 1, true);


--
-- Data for Name: matches; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY matches (id, male_id, female_id) FROM stdin;
\.


--
-- Name: matches_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('matches_id_seq', 1, false);


--
-- Name: females_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY females
    ADD CONSTRAINT females_pkey PRIMARY KEY (id);


--
-- Name: males_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY males
    ADD CONSTRAINT males_pkey PRIMARY KEY (id);


--
-- Name: matches_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest; Tablespace: 
--

ALTER TABLE ONLY matches
    ADD CONSTRAINT matches_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: Guest
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Guest";
GRANT ALL ON SCHEMA public TO "Guest";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

