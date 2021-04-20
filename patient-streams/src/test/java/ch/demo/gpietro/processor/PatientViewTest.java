package ch.demo.gpietro.processor;

/*
class PatientViewTest {

    private static final String SCHEMA_REGISTRY_SCOPE = PatientViewTest.class.getName();
    private static final String MOCK_SCHEMA_REGISTRY_URL = "mock://" + SCHEMA_REGISTRY_SCOPE;

    private TopologyTestDriver testDriver;

    private TestInputTopic<Long, Patient> mysqlPatientsTopic;

    @BeforeEach
    void beforeEach() throws Exception {
        // Create topology
        final StreamsBuilder builder = new StreamsBuilder();
        new PatientView(MOCK_SCHEMA_REGISTRY_URL).buildPatientView(builder);
        Topology topology = builder.build();

        Properties props = new Properties();
        props.putAll(Map.of(
                StreamsConfig.APPLICATION_ID_CONFIG, "test-app",
                StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "dummy:9092",
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.LongSerde.class,
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class,
                AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, MOCK_SCHEMA_REGISTRY_URL
        ));

        // Create test driver
        testDriver = new TopologyTestDriver(topology, props);

        Serde<Long> longSerde = Serdes.Long();
        Serde<Patient> avroPatientSerde = new SpecificAvroSerde<>();

        // Configure Serdes to use the same mock schema registry
        Map<String, String> config = Map.of(
                AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, MOCK_SCHEMA_REGISTRY_URL
        );
        avroPatientSerde.configure(config, false);

        mysqlPatientsTopic = testDriver.createInputTopic(
                "mysql.admindb.patients",
                longSerde.serializer(),
                avroPatientSerde.serializer()
        );
    }

    @AfterEach
    void afterEach() {
        testDriver.close();
        MockSchemaRegistry.dropScope(SCHEMA_REGISTRY_SCOPE);
    }

    @Test
    void shouldCreateMaterializedView() {
        Patient p1 = new Patient();
        p1.setId(1L);
        p1.setFirstName("Pietro");
        p1.setLastName("Ghezzi");
        p1.setBirthDate(new Date(1986, 06, 28).toInstant());
        p1.setCreatedAt(new Date().toInstant());
        p1.setUpdatedAt(new Date().toInstant());
        mysqlPatientsTopic.pipeInput(1L, p1);

        Patient p2 = new Patient();
        p2.setId(2L);
        p2.setFirstName("Paolo");
        p2.setLastName("Maldini");
        p2.setBirthDate(new Date(1976, 06, 26).toInstant());
        p2.setCreatedAt(new Date().toInstant());
        p2.setUpdatedAt(new Date().toInstant());
        mysqlPatientsTopic.pipeInput(2L, p2);

        Patient p3 = p1;
        p3.setFirstName("Luigi");
        mysqlPatientsTopic.pipeInput(1L, p3);

        final KeyValueStore<Long, Patient> view = testDriver.getKeyValueStore("view.patients");
        assertThat(view.get(1L)).isEqualTo(p3);
        assertThat(view.get(2L)).isEqualTo(p2);
    }
}
 */