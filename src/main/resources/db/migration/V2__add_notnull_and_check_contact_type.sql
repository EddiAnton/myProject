-- Устанавливаем ограничение NOT NULL
ALTER TABLE contacts ALTER COLUMN contact_type SET NOT NULL;

-- Добавляем CHECK-ограничение
ALTER TABLE contacts ADD CONSTRAINT contacts_contact_type_check
    CHECK (contact_type IN ('PHONE','EMAIL','ADDRESS'));
