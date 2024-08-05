-- Créer la séquence pour les identifiants des utilisateurs
CREATE SEQUENCE user_id_seq;

-- Créer la table des utilisateurs
CREATE TABLE users
(
    id integer NOT NULL DEFAULT nextval('user_id_seq'),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) DEFAULT 'USER',
    PRIMARY KEY (id)
);

-- Assigner la séquence à la colonne id de la table user
ALTER SEQUENCE user_id_seq OWNED BY users.id;
-- Changer le propriétaire de la table user à l'utilisateur postgres
ALTER TABLE IF EXISTS public.users OWNER TO postgres;
-- Insérer un utilisateur admin
INSERT INTO public.users (name, email, password, role) VALUES ('admin', 'admin@localhost', 'admin', 'ADMIN');

