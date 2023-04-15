create database file_managment;

-- public.item_types definition

-- Drop table

-- DROP TABLE public.item_types;

CREATE TABLE public.item_types (
	type_id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	type_name varchar(30) NULL,
	CONSTRAINT item_types_pkey PRIMARY KEY (type_id)
);


-- public.item_permission_groups definition

-- Drop table

-- DROP TABLE public.item_permission_groups;

CREATE TABLE public.item_permission_groups (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	group_name varchar(30) NULL,
	CONSTRAINT item_permission_groups_pkey PRIMARY KEY (id)
);

-- public.item definition

-- Drop table

-- DROP TABLE public.item;

CREATE TABLE public.item (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	item_type_id int4 NULL,
	item_name varchar(30) NULL,
	permission_group_id int4 NULL,
	parent_id int4 NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id)
);


-- public.item foreign keys

ALTER TABLE public.item ADD CONSTRAINT fk_permission_group FOREIGN KEY (permission_group_id) REFERENCES public.item_permission_groups(id);


-- public.permission_groups definition

-- Drop table

-- DROP TABLE public.permission_groups;

CREATE TABLE public.permission_groups (
	id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	user_email varchar(100) NULL,
	permission_level varchar(30) NULL,
	item_group_id int4 NULL,
	CONSTRAINT permission_groups_pkey PRIMARY KEY (id)
);


-- public.permission_groups foreign keys

ALTER TABLE public.permission_groups ADD CONSTRAINT groups_if_fk FOREIGN KEY (item_group_id) REFERENCES public.item_permission_groups(id);

-- public.file_item definition

-- Drop table

-- DROP TABLE public.file_item;

CREATE TABLE public.file_item (
	id int4 NOT NULL,
	file_text bytea NULL,
	item_id int4 NULL,
	CONSTRAINT file_item_pkey PRIMARY KEY (id)
);


-- public.file_item foreign keys

ALTER TABLE public.file_item ADD CONSTRAINT fk_file_item FOREIGN KEY (item_id) REFERENCES public.item(id);


INSERT INTO public.item_types
(type_name)
VALUES ('space'),
('folder'),('file'); 

INSERT INTO public.item_permission_groups
(group_name)
VALUES('admin'),('user');

INSERT INTO public.permission_groups
(user_email, permission_level, item_group_id)
VALUES('mostafa.mohamed.ahmed94@gmail.com', 'view', 1),('mohamed.ahmed64@gmail.com', 'edit', 1);
