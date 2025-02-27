PGDMP  1                    |         	   instituto    16.2    16.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16792 	   instituto    DATABASE     {   CREATE DATABASE instituto WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE instituto;
                postgres    false            �            1259    16803    curso    TABLE     �   CREATE TABLE public.curso (
    curso_id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    profesor character varying(255) NOT NULL,
    descripcion character varying(255) NOT NULL
);
    DROP TABLE public.curso;
       public         heap    postgres    false            �            1259    16802    curso_curso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.curso_curso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.curso_curso_id_seq;
       public          postgres    false    216            �           0    0    curso_curso_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.curso_curso_id_seq OWNED BY public.curso.curso_id;
          public          postgres    false    215            �            1259    16835 
   estudiante    TABLE     *  CREATE TABLE public.estudiante (
    estudiante_id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    edad integer NOT NULL,
    curso integer NOT NULL,
    direccion character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    telefono character varying(255)
);
    DROP TABLE public.estudiante;
       public         heap    postgres    false            �            1259    16834    estudinate_estudiante_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estudinate_estudiante_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.estudinate_estudiante_id_seq;
       public          postgres    false    218            �           0    0    estudinate_estudiante_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.estudinate_estudiante_id_seq OWNED BY public.estudiante.estudiante_id;
          public          postgres    false    217                       2604    16806    curso curso_id    DEFAULT     p   ALTER TABLE ONLY public.curso ALTER COLUMN curso_id SET DEFAULT nextval('public.curso_curso_id_seq'::regclass);
 =   ALTER TABLE public.curso ALTER COLUMN curso_id DROP DEFAULT;
       public          postgres    false    215    216    216                        2604    16838    estudiante estudiante_id    DEFAULT     �   ALTER TABLE ONLY public.estudiante ALTER COLUMN estudiante_id SET DEFAULT nextval('public.estudinate_estudiante_id_seq'::regclass);
 G   ALTER TABLE public.estudiante ALTER COLUMN estudiante_id DROP DEFAULT;
       public          postgres    false    218    217    218            �          0    16803    curso 
   TABLE DATA           H   COPY public.curso (curso_id, nombre, profesor, descripcion) FROM stdin;
    public          postgres    false    216          �          0    16835 
   estudiante 
   TABLE DATA           e   COPY public.estudiante (estudiante_id, nombre, edad, curso, direccion, correo, telefono) FROM stdin;
    public          postgres    false    218   �       �           0    0    curso_curso_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.curso_curso_id_seq', 2, true);
          public          postgres    false    215            �           0    0    estudinate_estudiante_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.estudinate_estudiante_id_seq', 2, true);
          public          postgres    false    217            "           2606    16810    curso curso_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (curso_id);
 :   ALTER TABLE ONLY public.curso DROP CONSTRAINT curso_pkey;
       public            postgres    false    216            $           2606    16842    estudiante estudinate_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudinate_pkey PRIMARY KEY (estudiante_id);
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudinate_pkey;
       public            postgres    false    218            %           2606    16843    estudiante curso_fk    FK CONSTRAINT     v   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT curso_fk FOREIGN KEY (curso) REFERENCES public.curso(curso_id);
 =   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT curso_fk;
       public          postgres    false    218    4642    216            �   �   x��K
�0���)���(EQ��n��M�H'u�,<�G�bF��ck.R4��}���@	ԥ)k,s� �����,%��͓b�?�;���¾Tŏ����;����1rJٜo��@/�����Z�ɡ/�      �   t   x�3�tͫ�W���M��42�4�t,SH-:�K��Ȅ3(��sH�M���K���4�060476�2��*M�S�,K,i6kN�K�=�P��Ȑ�$�T���������А+F��� �"%�     