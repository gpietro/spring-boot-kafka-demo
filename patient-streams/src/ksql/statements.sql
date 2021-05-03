SET 'auto.offset.reset' = 'earliest';

CREATE STREAM board (
    wardId INT,
    patientId INT,
    roomId INT,
    bedId INT,
    treatmentId INT,
    first_name VARCHAR,
    last_name VARCHAR,
    status VARCHAR,
    birth_date INT
) WITH (
    kafka_topic = 'board',
    partitions = 1,
    value_format = 'AVRO'
);

CREATE STREAM board_active_ward3 AS
SELECT patientId, roomId, bedId, treatmentId, first_name, last_name, birth_date
FROM board
WHERE status = 'ACTIVE' and wardId = 3;

CREATE STREAM board_past_ward3 AS
SELECT patientId, treatmentId, first_name, last_name, birth_date
FROM board
WHERE status = 'PAST' and wardId = 3;