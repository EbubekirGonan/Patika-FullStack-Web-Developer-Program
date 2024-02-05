PGDMP     -    !                |            TourismAgencyApp "   12.17 (Ubuntu 12.17-1.pgdg22.04+1) "   12.17 (Ubuntu 12.17-1.pgdg22.04+1) *    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16933    TourismAgencyApp    DATABASE     �   CREATE DATABASE "TourismAgencyApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
 "   DROP DATABASE "TourismAgencyApp";
                postgres    false            �            1259    16934    hotel    TABLE     T  CREATE TABLE public.hotel (
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
    "7/24_room_service" boolean
);
    DROP TABLE public.hotel;
       public         heap    postgres    false            �            1259    16968    hotel_hotel_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_hotel_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hotel_hotel_id_seq;
       public          postgres    false    202            �           0    0    hotel_hotel_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.hotel_hotel_id_seq OWNED BY public.hotel.hotel_id;
          public          postgres    false    209            �            1259    16937    hotel_pension    TABLE     }   CREATE TABLE public.hotel_pension (
    pension_id smallint NOT NULL,
    pension_hotel_id integer,
    pension_type text
);
 !   DROP TABLE public.hotel_pension;
       public         heap    postgres    false            �            1259    16987 "   hotel_pension_hotel_pension_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_pension_hotel_pension_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.hotel_pension_hotel_pension_id_seq;
       public          postgres    false    203            �           0    0 "   hotel_pension_hotel_pension_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.hotel_pension_hotel_pension_id_seq OWNED BY public.hotel_pension.pension_id;
          public          postgres    false    211            �            1259    16940    hotel_season    TABLE     �   CREATE TABLE public.hotel_season (
    season_id smallint NOT NULL,
    hotel_id integer,
    season_strt_date date,
    season_fnsh_date date
);
     DROP TABLE public.hotel_season;
       public         heap    postgres    false            �            1259    16979    hotel_season_season_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotel_season_season_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.hotel_season_season_id_seq;
       public          postgres    false    204            �           0    0    hotel_season_season_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.hotel_season_season_id_seq OWNED BY public.hotel_season.season_id;
          public          postgres    false    210            �            1259    16943    reservation    TABLE     %   CREATE TABLE public.reservation (
);
    DROP TABLE public.reservation;
       public         heap    postgres    false            �            1259    16946    room    TABLE     �  CREATE TABLE public.room (
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
       public         heap    postgres    false            �            1259    16998    room_room_id_seq    SEQUENCE     �   CREATE SEQUENCE public.room_room_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.room_room_id_seq;
       public          postgres    false    206            �           0    0    room_room_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.room_room_id_seq OWNED BY public.room.room_id;
          public          postgres    false    212            �            1259    16949    user    TABLE     ~   CREATE TABLE public."user" (
    user_id smallint NOT NULL,
    user_name text,
    user_password text,
    user_role text
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    16957    user_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_user_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.user_user_id_seq;
       public          postgres    false    207            �           0    0    user_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.user_user_id_seq OWNED BY public."user".user_id;
          public          postgres    false    208            S           2604    16970    hotel hotel_id    DEFAULT     p   ALTER TABLE ONLY public.hotel ALTER COLUMN hotel_id SET DEFAULT nextval('public.hotel_hotel_id_seq'::regclass);
 =   ALTER TABLE public.hotel ALTER COLUMN hotel_id DROP DEFAULT;
       public          postgres    false    209    202            T           2604    16989    hotel_pension pension_id    DEFAULT     �   ALTER TABLE ONLY public.hotel_pension ALTER COLUMN pension_id SET DEFAULT nextval('public.hotel_pension_hotel_pension_id_seq'::regclass);
 G   ALTER TABLE public.hotel_pension ALTER COLUMN pension_id DROP DEFAULT;
       public          postgres    false    211    203            U           2604    16981    hotel_season season_id    DEFAULT     �   ALTER TABLE ONLY public.hotel_season ALTER COLUMN season_id SET DEFAULT nextval('public.hotel_season_season_id_seq'::regclass);
 E   ALTER TABLE public.hotel_season ALTER COLUMN season_id DROP DEFAULT;
       public          postgres    false    210    204            V           2604    17000    room room_id    DEFAULT     l   ALTER TABLE ONLY public.room ALTER COLUMN room_id SET DEFAULT nextval('public.room_room_id_seq'::regclass);
 ;   ALTER TABLE public.room ALTER COLUMN room_id DROP DEFAULT;
       public          postgres    false    212    206            W           2604    16959    user user_id    DEFAULT     n   ALTER TABLE ONLY public."user" ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);
 =   ALTER TABLE public."user" ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    208    207            �          0    16934    hotel 
   TABLE DATA           �   COPY public.hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_phone, hotel_star, free_parking, free_wifi, pool, fitness_center, concierge, spa, "7/24_room_service") FROM stdin;
    public          postgres    false    202   �/       �          0    16937    hotel_pension 
   TABLE DATA           S   COPY public.hotel_pension (pension_id, pension_hotel_id, pension_type) FROM stdin;
    public          postgres    false    203   �/       �          0    16940    hotel_season 
   TABLE DATA           _   COPY public.hotel_season (season_id, hotel_id, season_strt_date, season_fnsh_date) FROM stdin;
    public          postgres    false    204   70       �          0    16943    reservation 
   TABLE DATA           %   COPY public.reservation  FROM stdin;
    public          postgres    false    205   �0       �          0    16946    room 
   TABLE DATA           �   COPY public.room (room_id, room_hotel_id, room_pension, room_type, stock, adult_price, child_price, room_season_id, bed_count, area, tv, minibar, game_console, safe_case, projector) FROM stdin;
    public          postgres    false    206   �0       �          0    16949    user 
   TABLE DATA           N   COPY public."user" (user_id, user_name, user_password, user_role) FROM stdin;
    public          postgres    false    207   K1       �           0    0    hotel_hotel_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hotel_hotel_id_seq', 10, true);
          public          postgres    false    209            �           0    0 "   hotel_pension_hotel_pension_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.hotel_pension_hotel_pension_id_seq', 7, true);
          public          postgres    false    211            �           0    0    hotel_season_season_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.hotel_season_season_id_seq', 10, true);
          public          postgres    false    210            �           0    0    room_room_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.room_room_id_seq', 6, true);
          public          postgres    false    212            �           0    0    user_user_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_user_id_seq', 18, true);
          public          postgres    false    208            [           2606    16994     hotel_pension hotel_pension_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.hotel_pension
    ADD CONSTRAINT hotel_pension_pkey PRIMARY KEY (pension_id);
 J   ALTER TABLE ONLY public.hotel_pension DROP CONSTRAINT hotel_pension_pkey;
       public            postgres    false    203            Y           2606    16978    hotel hotel_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.hotel
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (hotel_id);
 :   ALTER TABLE ONLY public.hotel DROP CONSTRAINT hotel_pkey;
       public            postgres    false    202            ]           2606    16986    hotel_season hotel_season_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.hotel_season
    ADD CONSTRAINT hotel_season_pkey PRIMARY KEY (season_id);
 H   ALTER TABLE ONLY public.hotel_season DROP CONSTRAINT hotel_season_pkey;
       public            postgres    false    204            _           2606    17005    room room_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (room_id);
 8   ALTER TABLE ONLY public.room DROP CONSTRAINT room_pkey;
       public            postgres    false    206            a           2606    16967    user user_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    207            b           2606    17006    room room_hotel_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_hotel_id FOREIGN KEY (room_hotel_id) REFERENCES public.hotel(hotel_id) NOT VALID;
 <   ALTER TABLE ONLY public.room DROP CONSTRAINT room_hotel_id;
       public          postgres    false    2905    206    202            �   >   x�3�LI�K�M�Niq��ag�%gIjq	:��C��.C��:���3Bs��qqq ��#R      �   /   x���  �ޛbP����C|�p-��h��N�������<�Z      �   \   x�m���0�7�%��]��%m����dKUR�ZDˌVX�:�8%%��m")��K,;-"��ZŹ�ep��%�s�|����WG$#      �      x������ � �      �   {   x�M�A�0��1��&�/����!�X�^9�p��K��U�q�:�%���=�f$�ۇ���S:��d��l׃JR{|W�|�
�.�X���4Z@*N��Yآ�a�t�B.ү���?/3�%�      �   ;   x�3�LL���3�4426�4�2�LM����!�F0ICS� �o���[��_������ &��     