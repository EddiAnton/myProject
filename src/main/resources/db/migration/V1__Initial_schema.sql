CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Таблица персон
CREATE TABLE persons (
                         uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         surname VARCHAR(100) NOT NULL
);

-- Таблица контактов
CREATE TABLE contacts (
                          uuid UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          contact_type VARCHAR(20) NOT NULL,
                          person_uuid UUID REFERENCES persons(uuid) ON DELETE CASCADE,
                          phone_type VARCHAR(50),
                          phone_number VARCHAR(20),
                          email_type VARCHAR(50),
                          email VARCHAR(255),
                          city VARCHAR(100),
                          street VARCHAR(255),
                          house VARCHAR(20),
                          apartment VARCHAR(20)
);

-- Индексы
CREATE INDEX idx_contacts_person ON contacts(person_uuid);

-- Комментарии к таблицам
COMMENT ON TABLE persons IS 'Таблица персон';
COMMENT ON COLUMN persons.uuid IS 'Идентификатор персоны';
COMMENT ON COLUMN persons.first_name IS 'Имя';
COMMENT ON COLUMN persons.last_name IS 'Отчество';
COMMENT ON COLUMN persons.surname IS 'Фамилия';

COMMENT ON TABLE contacts IS 'Таблица контактов';
COMMENT ON COLUMN contacts.uuid IS 'Идентификатор контакта';
COMMENT ON COLUMN contacts.contact_type IS 'Тип контакта: PHONE, EMAIL, ADDRESS';
COMMENT ON COLUMN contacts.person_uuid IS 'Ссылка на персону';
COMMENT ON COLUMN contacts.phone_type IS 'Тип телефона';
COMMENT ON COLUMN contacts.phone_number IS 'Номер телефона';
COMMENT ON COLUMN contacts.email_type IS 'Тип email';
COMMENT ON COLUMN contacts.email IS 'Адрес электронной почты';
COMMENT ON COLUMN contacts.city IS 'Город (для адреса)';
COMMENT ON COLUMN contacts.street IS 'Улица (для адреса)';
COMMENT ON COLUMN contacts.house IS 'Номер дома (для адреса)';
COMMENT ON COLUMN contacts.apartment IS 'Номер квартиры (для адреса)';
