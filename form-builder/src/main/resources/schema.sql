CREATE TABLE forms (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE fields (
    id SERIAL PRIMARY KEY,
    form_id INTEGER REFERENCES forms(id),
    label VARCHAR(255) NOT NULL,
    is_required BOOLEAN NOT NULL,
    type VARCHAR(50) NOT NULL,
    max_length INTEGER,
    min_length INTEGER,
    allowed_pattern VARCHAR(255),
    max_value DOUBLE PRECISION,
    min_value DOUBLE PRECISION,
    is_integer BOOLEAN,
    max_decimal_places INTEGER
);
