CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Таблица персон
CREATE TABLE persons (
                         uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         surname VARCHAR(100) NOT NULL
);

-- Основная таблица контактов
CREATE TABLE contacts (
                          contact_uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          contact_type VARCHAR(20) NOT NULL,
                          person_uuid UUID
);

-- Таблица телефонов
CREATE TABLE phones (
                        uuid UUID PRIMARY KEY REFERENCES contacts(contact_uuid) ON DELETE CASCADE,
                        phone_type VARCHAR(50),
                        phone_number VARCHAR(20) NOT NULL
);

-- Таблица email
CREATE TABLE emails (
                        uuid UUID PRIMARY KEY REFERENCES contacts(contact_uuid) ON DELETE CASCADE,
                        email_type VARCHAR(50),
                        email VARCHAR(255) NOT NULL
);

-- Таблица адресов
CREATE TABLE addresses (
                           uuid UUID PRIMARY KEY REFERENCES contacts(contact_uuid) ON DELETE CASCADE,
                           city VARCHAR(100) NOT NULL,
                           street VARCHAR(255) NOT NULL,
                           house VARCHAR(20) NOT NULL,
                           apartment VARCHAR(20)
);

-- Добавляем внешний ключ
ALTER TABLE contacts ADD CONSTRAINT fk_contact_person
    FOREIGN KEY (person_uuid) REFERENCES persons(uuid) ON DELETE CASCADE;

-- Добавляем индекс
CREATE INDEX idx_contacts_person ON contacts(person_uuid);

-- Добавляем описание таблиц
COMMENT ON TABLE persons IS 'Таблица персон';
COMMENT ON COLUMN persons.uuid IS 'Идентификатор персоны';
COMMENT ON COLUMN persons.first_name IS 'Имя';
COMMENT ON COLUMN persons.last_name IS 'Отчество';
COMMENT ON COLUMN persons.surname IS 'Фамилия';

COMMENT ON TABLE contacts IS 'Контакты персон';
COMMENT ON COLUMN contacts.contact_uuid IS 'Идентификатор';
COMMENT ON COLUMN contacts.contact_type IS 'Тип контакта';
COMMENT ON COLUMN contacts.person_uuid IS 'Идентификатор персоны';

COMMENT ON TABLE phones IS 'Таблица телефонов';
COMMENT ON COLUMN phones.uuid IS 'Идентификатор контакта';
COMMENT ON COLUMN phones.phone_type IS 'Тип номера телефона';
COMMENT ON COLUMN phones.phone_number IS 'Номер телефона';

COMMENT ON TABLE emails IS 'Таблица эл. почт';
COMMENT ON COLUMN emails.uuid IS 'Идентификатор контакта';
COMMENT ON COLUMN emails.email_type IS 'Тип эл. почты';
COMMENT ON COLUMN emails.email IS 'Адрес эл. почты';

COMMENT ON TABLE addresses IS 'Таблица адресов';
COMMENT ON COLUMN addresses.uuid IS 'Идентификатор контакта';
COMMENT ON COLUMN addresses.city IS 'Город';
COMMENT ON COLUMN addresses.street IS 'Улица';
COMMENT ON COLUMN addresses.house IS 'Номер дома';
COMMENT ON COLUMN addresses.apartment IS 'Номер квартиры';
