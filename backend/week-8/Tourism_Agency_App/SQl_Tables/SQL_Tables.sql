toc.dat                                                                                             0000600 0004000 0002000 00000032663 14561444077 0014465 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       :    +        	        |            TourismAgencyApp "   12.17 (Ubuntu 12.17-1.pgdg22.04+1) "   12.17 (Ubuntu 12.17-1.pgdg22.04+1) .    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         �           1262    16933    TourismAgencyApp    DATABASE     �   CREATE DATABASE "TourismAgencyApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
 "   DROP DATABASE "TourismAgencyApp";
                postgres    false         �            1259    16934    hotel    TABLE     M  CREATE TABLE public.hotel (
    hotel_id smallint NOT NULL,
    hotel_name text,
    hotel_address text,
    hotel_email text,
    hotel_phone text,
    hotel_star text,
    free_parking boolean,
    free_wifi boolean,
    pool boolean,
    fitness_center boolean,
    concierge boolean,
    spa boolean,
    room_service boolean
);
    DROP TABLE public.hotel;
       public         heap    postgres    false         �            1259    16968    hotel_hotel_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_hotel_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hotel_hotel_id_seq;
       public          postgres    false    202         �           0    0    hotel_hotel_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.hotel_hotel_id_seq OWNED BY public.hotel.hotel_id;
          public          postgres    false    209         �            1259    16937    hotel_pension    TABLE     }   CREATE TABLE public.hotel_pension (
    pension_id smallint NOT NULL,
    pension_hotel_id integer,
    pension_type text
);
 !   DROP TABLE public.hotel_pension;
       public         heap    postgres    false         �            1259    16987 "   hotel_pension_hotel_pension_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_pension_hotel_pension_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.hotel_pension_hotel_pension_id_seq;
       public          postgres    false    203         �           0    0 "   hotel_pension_hotel_pension_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.hotel_pension_hotel_pension_id_seq OWNED BY public.hotel_pension.pension_id;
          public          postgres    false    211         �            1259    16940    hotel_season    TABLE     �   CREATE TABLE public.hotel_season (
    season_id smallint NOT NULL,
    season_hotel_id integer,
    season_strt_date date,
    season_fnsh_date date
);
     DROP TABLE public.hotel_season;
       public         heap    postgres    false         �            1259    16979    hotel_season_season_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_season_season_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.hotel_season_season_id_seq;
       public          postgres    false    204         �           0    0    hotel_season_season_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.hotel_season_season_id_seq OWNED BY public.hotel_season.season_id;
          public          postgres    false    210         �            1259    16943    reservation    TABLE     [  CREATE TABLE public.reservation (
    reservation_id bigint NOT NULL,
    reservation_room_id integer,
    check_in_date date,
    check_out_date date,
    total_price integer,
    guest_count integer,
    guest_name text,
    guest_citizen_id text,
    guest_mail text,
    guest_phone text,
    num_of_adult integer,
    num_of_child integer
);
    DROP TABLE public.reservation;
       public         heap    postgres    false         �            1259    17014    reservation_reservation_id_seq    SEQUENCE     �   CREATE SEQUENCE public.reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.reservation_reservation_id_seq;
       public          postgres    false    205         �           0    0    reservation_reservation_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.reservation_reservation_id_seq OWNED BY public.reservation.reservation_id;
          public          postgres    false    213         �            1259    16946    room    TABLE     �  CREATE TABLE public.room (
    room_id smallint NOT NULL,
    room_hotel_id smallint NOT NULL,
    room_pension text,
    room_type text,
    stock integer,
    adult_price integer,
    child_price integer,
    room_season_id integer,
    bed_count integer,
    area integer,
    tv boolean,
    minibar boolean,
    game_console boolean,
    safe_case boolean,
    projector boolean
);
    DROP TABLE public.room;
       public         heap    postgres    false         �            1259    16998    room_room_id_seq    SEQUENCE     �   CREATE SEQUENCE public.room_room_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.room_room_id_seq;
       public          postgres    false    206         �           0    0    room_room_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.room_room_id_seq OWNED BY public.room.room_id;
          public          postgres    false    212         �            1259    16949    user    TABLE     ~   CREATE TABLE public."user" (
    user_id smallint NOT NULL,
    user_name text,
    user_password text,
    user_role text
);
    DROP TABLE public."user";
       public         heap    postgres    false         �            1259    16957    user_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_user_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.user_user_id_seq;
       public          postgres    false    207         �           0    0    user_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.user_user_id_seq OWNED BY public."user".user_id;
          public          postgres    false    208         V           2604    16970    hotel hotel_id    DEFAULT     p   ALTER TABLE ONLY public.hotel ALTER COLUMN hotel_id SET DEFAULT nextval('public.hotel_hotel_id_seq'::regclass);
 =   ALTER TABLE public.hotel ALTER COLUMN hotel_id DROP DEFAULT;
       public          postgres    false    209    202         W           2604    16989    hotel_pension pension_id    DEFAULT     �   ALTER TABLE ONLY public.hotel_pension ALTER COLUMN pension_id SET DEFAULT nextval('public.hotel_pension_hotel_pension_id_seq'::regclass);
 G   ALTER TABLE public.hotel_pension ALTER COLUMN pension_id DROP DEFAULT;
       public          postgres    false    211    203         X           2604    16981    hotel_season season_id    DEFAULT     �   ALTER TABLE ONLY public.hotel_season ALTER COLUMN season_id SET DEFAULT nextval('public.hotel_season_season_id_seq'::regclass);
 E   ALTER TABLE public.hotel_season ALTER COLUMN season_id DROP DEFAULT;
       public          postgres    false    210    204         Y           2604    17016    reservation reservation_id    DEFAULT     �   ALTER TABLE ONLY public.reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.reservation_reservation_id_seq'::regclass);
 I   ALTER TABLE public.reservation ALTER COLUMN reservation_id DROP DEFAULT;
       public          postgres    false    213    205         Z           2604    17000    room room_id    DEFAULT     l   ALTER TABLE ONLY public.room ALTER COLUMN room_id SET DEFAULT nextval('public.room_room_id_seq'::regclass);
 ;   ALTER TABLE public.room ALTER COLUMN room_id DROP DEFAULT;
       public          postgres    false    212    206         [           2604    16959    user user_id    DEFAULT     n   ALTER TABLE ONLY public."user" ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);
 =   ALTER TABLE public."user" ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    208    207         �          0    16934    hotel 
   TABLE DATA           �   COPY public.hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_phone, hotel_star, free_parking, free_wifi, pool, fitness_center, concierge, spa, room_service) FROM stdin;
    public          postgres    false    202       3046.dat �          0    16937    hotel_pension 
   TABLE DATA           S   COPY public.hotel_pension (pension_id, pension_hotel_id, pension_type) FROM stdin;
    public          postgres    false    203       3047.dat �          0    16940    hotel_season 
   TABLE DATA           f   COPY public.hotel_season (season_id, season_hotel_id, season_strt_date, season_fnsh_date) FROM stdin;
    public          postgres    false    204       3048.dat �          0    16943    reservation 
   TABLE DATA           �   COPY public.reservation (reservation_id, reservation_room_id, check_in_date, check_out_date, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, num_of_adult, num_of_child) FROM stdin;
    public          postgres    false    205       3049.dat �          0    16946    room 
   TABLE DATA           �   COPY public.room (room_id, room_hotel_id, room_pension, room_type, stock, adult_price, child_price, room_season_id, bed_count, area, tv, minibar, game_console, safe_case, projector) FROM stdin;
    public          postgres    false    206       3050.dat �          0    16949    user 
   TABLE DATA           N   COPY public."user" (user_id, user_name, user_password, user_role) FROM stdin;
    public          postgres    false    207       3051.dat �           0    0    hotel_hotel_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 28, true);
          public          postgres    false    209         �           0    0 "   hotel_pension_hotel_pension_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.hotel_pension_hotel_pension_id_seq', 27, true);
          public          postgres    false    211                     0    0    hotel_season_season_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.hotel_season_season_id_seq', 29, true);
          public          postgres    false    210                    0    0    reservation_reservation_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.reservation_reservation_id_seq', 34, true);
          public          postgres    false    213                    0    0    room_room_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.room_room_id_seq', 33, true);
          public          postgres    false    212                    0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 30, true);
          public          postgres    false    208         _           2606    16994     hotel_pension hotel_pension_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.hotel_pension
    ADD CONSTRAINT hotel_pension_pkey PRIMARY KEY (pension_id);
 J   ALTER TABLE ONLY public.hotel_pension DROP CONSTRAINT hotel_pension_pkey;
       public            postgres    false    203         ]           2606    16978    hotel hotel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    202         a           2606    16986    hotel_season hotel_season_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.hotel_season
    ADD CONSTRAINT hotel_season_pkey PRIMARY KEY (season_id);
 H   ALTER TABLE ONLY public.hotel_season DROP CONSTRAINT hotel_season_pkey;
       public            postgres    false    204         c           2606    17024    reservation reservation_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reservation_id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    205         e           2606    17005    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    206         g           2606    16967    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    207                                                                                     3046.dat                                                                                            0000600 0004000 0002000 00000000533 14561444077 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        24	Hilton	Kozyatağı	hilton@gmail.com	05005556633	***	t	t	t	t	t	f	f
25	ramada	beşiktaş	ramada@gmail.com	05506667686	****	t	t	t	t	t	f	f
26	sheraton	taksim	sheraton@gmail.com	05554447868	*****	t	t	t	t	f	f	f
27	Marmara	taksim	marmara@gmail.com	05557774433	***	t	f	f	t	t	t	t
28	Selimiye	üsküdar	selim@gmail.com	05512345765	***	t	t	t	f	f	f	f
\.


                                                                                                                                                                     3047.dat                                                                                            0000600 0004000 0002000 00000000125 14561444077 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        18	24	2
19	24	5
20	25	6
21	25	0
22	26	3
23	26	1
24	27	0
25	27	5
26	28	3
27	28	6
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                           3048.dat                                                                                            0000600 0004000 0002000 00000000435 14561444077 0014266 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        20	24	2024-01-01	2024-03-31
21	24	2024-04-01	2024-07-31
22	25	2024-03-01	2024-08-31
23	25	2024-09-01	2024-12-31
24	26	2024-02-10	2024-03-01
25	26	2024-04-01	2024-06-01
26	27	2024-04-01	2024-06-01
27	27	2024-06-02	2024-10-31
28	28	2024-06-01	2024-09-01
29	28	2024-09-02	2024-12-31
\.


                                                                                                                                                                                                                                   3049.dat                                                                                            0000600 0004000 0002000 00000000714 14561444077 0014267 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        30	24	2024-01-01	2024-01-10	27000	2	Ebubekir Gönan	7476465476	ebbkr@gmail.com	05006667611	2	0
31	26	2024-03-01	2024-04-10	304000	2	Ebubekir Gönan	2435322523	ebbkr@gmail.com	23523532235	2	0
32	29	2024-04-02	2024-04-12	54000	2	Ebubekir Gönan	23433443	ebbkr@gmail.com	4344343466	2	0
33	30	2024-04-02	2024-04-12	86000	2	Ebubekir Gönan	23345347	ebbkr@gmail.com		2	0
34	33	2024-06-02	2024-06-20	115200	2	Ebubekir Gönan	32345677	ebbkr@gmail.com	5754321	2	0
\.


                                                    3050.dat                                                                                            0000600 0004000 0002000 00000000630 14561444077 0014254 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        29	26	1	2	6	2700	2500	25	2	50	t	f	f	f	t
30	27	0	1	5	4300	2800	26	3	46	f	t	f	f	f
33	28	6	1	15	3200	3000	29	2	26	f	t	t	f	t
25	24	5	2	12	2000	1800	21	4	45	t	f	t	f	f
27	25	0	0	6	5900	5000	23	1	24	t	f	f	f	t
28	26	3	1	5	3200	2800	24	2	18	t	f	f	f	t
31	27	5	0	3	2100	2000	27	1	18	f	t	f	f	f
32	28	3	1	12	6100	5000	28	2	40	f	f	f	f	f
24	24	2	2	9	1500	1300	20	2	44	f	t	t	f	f
26	25	0	1	3	3800	3000	23	3	44	t	t	t	f	f
\.


                                                                                                        3051.dat                                                                                            0000600 0004000 0002000 00000000070 14561444077 0014253 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        28	employee	1234	1
29	admin2	1234	0
1	admin	1234	0
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                        restore.sql                                                                                         0000600 0004000 0002000 00000027643 14561444077 0015414 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 12.17 (Ubuntu 12.17-1.pgdg22.04+1)
-- Dumped by pg_dump version 12.17 (Ubuntu 12.17-1.pgdg22.04+1)

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

DROP DATABASE "TourismAgencyApp";
--
-- Name: TourismAgencyApp; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "TourismAgencyApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE "TourismAgencyApp" OWNER TO postgres;

\connect "TourismAgencyApp"

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel (
    hotel_id smallint NOT NULL,
    hotel_name text,
    hotel_address text,
    hotel_email text,
    hotel_phone text,
    hotel_star text,
    free_parking boolean,
    free_wifi boolean,
    pool boolean,
    fitness_center boolean,
    concierge boolean,
    spa boolean,
    room_service boolean
);


ALTER TABLE public.hotel OWNER TO postgres;

--
-- Name: hotel_hotel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hotel_hotel_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hotel_hotel_id_seq OWNER TO postgres;

--
-- Name: hotel_hotel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hotel_hotel_id_seq OWNED BY public.hotel.hotel_id;


--
-- Name: hotel_pension; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel_pension (
    pension_id smallint NOT NULL,
    pension_hotel_id integer,
    pension_type text
);


ALTER TABLE public.hotel_pension OWNER TO postgres;

--
-- Name: hotel_pension_hotel_pension_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hotel_pension_hotel_pension_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hotel_pension_hotel_pension_id_seq OWNER TO postgres;

--
-- Name: hotel_pension_hotel_pension_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hotel_pension_hotel_pension_id_seq OWNED BY public.hotel_pension.pension_id;


--
-- Name: hotel_season; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel_season (
    season_id smallint NOT NULL,
    season_hotel_id integer,
    season_strt_date date,
    season_fnsh_date date
);


ALTER TABLE public.hotel_season OWNER TO postgres;

--
-- Name: hotel_season_season_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hotel_season_season_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hotel_season_season_id_seq OWNER TO postgres;

--
-- Name: hotel_season_season_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hotel_season_season_id_seq OWNED BY public.hotel_season.season_id;


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    reservation_id bigint NOT NULL,
    reservation_room_id integer,
    check_in_date date,
    check_out_date date,
    total_price integer,
    guest_count integer,
    guest_name text,
    guest_citizen_id text,
    guest_mail text,
    guest_phone text,
    num_of_adult integer,
    num_of_child integer
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- Name: reservation_reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_reservation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_reservation_id_seq OWNER TO postgres;

--
-- Name: reservation_reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_reservation_id_seq OWNED BY public.reservation.reservation_id;


--
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    room_id smallint NOT NULL,
    room_hotel_id smallint NOT NULL,
    room_pension text,
    room_type text,
    stock integer,
    adult_price integer,
    child_price integer,
    room_season_id integer,
    bed_count integer,
    area integer,
    tv boolean,
    minibar boolean,
    game_console boolean,
    safe_case boolean,
    projector boolean
);


ALTER TABLE public.room OWNER TO postgres;

--
-- Name: room_room_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.room_room_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.room_room_id_seq OWNER TO postgres;

--
-- Name: room_room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.room_room_id_seq OWNED BY public.room.room_id;


--
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    user_id smallint NOT NULL,
    user_name text,
    user_password text,
    user_role text
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_user_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_user_id_seq OWNER TO postgres;

--
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_user_id_seq OWNED BY public."user".user_id;


--
-- Name: hotel hotel_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel ALTER COLUMN hotel_id SET DEFAULT nextval('public.hotel_hotel_id_seq'::regclass);


--
-- Name: hotel_pension pension_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_pension ALTER COLUMN pension_id SET DEFAULT nextval('public.hotel_pension_hotel_pension_id_seq'::regclass);


--
-- Name: hotel_season season_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_season ALTER COLUMN season_id SET DEFAULT nextval('public.hotel_season_season_id_seq'::regclass);


--
-- Name: reservation reservation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN reservation_id SET DEFAULT nextval('public.reservation_reservation_id_seq'::regclass);


--
-- Name: room room_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room ALTER COLUMN room_id SET DEFAULT nextval('public.room_room_id_seq'::regclass);


--
-- Name: user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);


--
-- Data for Name: hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_phone, hotel_star, free_parking, free_wifi, pool, fitness_center, concierge, spa, room_service) FROM stdin;
\.
COPY public.hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_phone, hotel_star, free_parking, free_wifi, pool, fitness_center, concierge, spa, room_service) FROM '$$PATH$$/3046.dat';

--
-- Data for Name: hotel_pension; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_pension (pension_id, pension_hotel_id, pension_type) FROM stdin;
\.
COPY public.hotel_pension (pension_id, pension_hotel_id, pension_type) FROM '$$PATH$$/3047.dat';

--
-- Data for Name: hotel_season; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_season (season_id, season_hotel_id, season_strt_date, season_fnsh_date) FROM stdin;
\.
COPY public.hotel_season (season_id, season_hotel_id, season_strt_date, season_fnsh_date) FROM '$$PATH$$/3048.dat';

--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (reservation_id, reservation_room_id, check_in_date, check_out_date, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, num_of_adult, num_of_child) FROM stdin;
\.
COPY public.reservation (reservation_id, reservation_room_id, check_in_date, check_out_date, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone, num_of_adult, num_of_child) FROM '$$PATH$$/3049.dat';

--
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (room_id, room_hotel_id, room_pension, room_type, stock, adult_price, child_price, room_season_id, bed_count, area, tv, minibar, game_console, safe_case, projector) FROM stdin;
\.
COPY public.room (room_id, room_hotel_id, room_pension, room_type, stock, adult_price, child_price, room_season_id, bed_count, area, tv, minibar, game_console, safe_case, projector) FROM '$$PATH$$/3050.dat';

--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (user_id, user_name, user_password, user_role) FROM stdin;
\.
COPY public."user" (user_id, user_name, user_password, user_role) FROM '$$PATH$$/3051.dat';

--
-- Name: hotel_hotel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 28, true);


--
-- Name: hotel_pension_hotel_pension_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotel_pension_hotel_pension_id_seq', 27, true);


--
-- Name: hotel_season_season_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotel_season_season_id_seq', 29, true);


--
-- Name: reservation_reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_reservation_id_seq', 34, true);


--
-- Name: room_room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.room_room_id_seq', 33, true);


--
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_user_id_seq', 30, true);


--
-- Name: hotel_pension hotel_pension_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_pension
    ADD CONSTRAINT hotel_pension_pkey PRIMARY KEY (pension_id);


--
-- Name: hotel hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);


--
-- Name: hotel_season hotel_season_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_season
    ADD CONSTRAINT hotel_season_pkey PRIMARY KEY (season_id);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (reservation_id);


--
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             