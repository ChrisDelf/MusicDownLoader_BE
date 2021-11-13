CREATE TABLE users(
    id uuid NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL

);

CREATE TABLE songs(
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genre VARCHAR(100),
    artist VARCHAR(100),
    length int,
    date date
);



INSERT INTO users(id, name, password)
VALUES ('3bf80cf2-436e-11ec-81d3-0242ac130003','Chris', 'password')


INSERT INTO songs(id, name)
VALUES(0,'RamlethalTheme-NecessaryDiscrepancy'),(1,'16. Requiem - Guilty Gear Strive OST (I-No`s Theme)'),
(2, '9. Love the Subhuman Self - Guilty Gear Strive OST (Millia Rage`s Theme)-1063907341'),(3,'7. Armor-Clad Faith - Guilty Gear Strive OST (Potemkin`s Theme)-1063907239')