package com.connect.demo.config;

import java.util.Properties;

import org.apache.kafka.connect.runtime.ConnectorConfig;
import org.apache.kafka.connect.runtime.distributed.DistributedConfig;

import com.connect.demo.embedded.ConnectEmbedded;

import io.confluent.connect.jdbc.JdbcSourceConnector;
import io.confluent.connect.jdbc.JdbcSourceConnectorConfig;

public class ConnectionConfiguration {

    public ConnectEmbedded connectConfig() throws Exception {

	Properties connectProp = new Properties();
	connectProp.put(ConnectorConfig.NAME_CONFIG, "test-mysql-jdbc-autoincrement");
	connectProp.put(ConnectorConfig.CONNECTOR_CLASS_CONFIG, "io.confluent.connect.jdbc.JdbcSourceConnector");
	connectProp.put(ConnectorConfig.TASKS_MAX_DEFAULT, 10);
	connectProp.put(JdbcSourceConnectorConfig.CONNECTION_URL_CONFIG,
		"jdbc:mysql://127.0.0.1:3306/bigData?autoReconnect=true&useSSL=false&user=root&password=root");
	connectProp.put(JdbcSourceConnectorConfig.TABLE_WHITELIST_CONFIG, "person");
	connectProp.put(JdbcSourceConnectorConfig.MODE_INCREMENTING, "id");
	connectProp.put(JdbcSourceConnectorConfig.INCREMENTING_COLUMN_NAME_DEFAULT, "id");
	connectProp.put(JdbcSourceConnectorConfig.TABLE_POLL_INTERVAL_MS_DEFAULT, 10000);
	connectProp.put(JdbcSourceConnectorConfig.TOPIC_PREFIX_CONFIG, "test-mysql-jdbc-");
	connectProp.put(JdbcSourceConnectorConfig.MODE_CONFIG, "incrementing");
	connectProp.put(JdbcSourceConnectorConfig.MODE_INCREMENTING, "incrementing");
	connectProp.put(JdbcSourceConnectorConfig.TIMESTAMP_DELAY_INTERVAL_MS_DEFAULT, 10000);
	connectProp.put(JdbcSourceConnectorConfig.POLL_INTERVAL_MS_CONFIG, 5000);
	connectProp.put(JdbcSourceConnectorConfig.TABLE_WHITELIST_DEFAULT, 5000);

	Properties workerProp = new Properties();
	workerProp.put(DistributedConfig.GROUP_ID_CONFIG, "bigData");
	workerProp.put(DistributedConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	workerProp.put(DistributedConfig.OFFSET_STORAGE_TOPIC_CONFIG, "bigData-offsets");
	workerProp.put(DistributedConfig.OFFSET_COMMIT_INTERVAL_MS_DEFAULT, 5000);

	workerProp.put(DistributedConfig.CONFIG_TOPIC_CONFIG, "bigData-configs");

	workerProp.put(DistributedConfig.STATUS_STORAGE_TOPIC_CONFIG, "bigData-Status");
	workerProp.put(DistributedConfig.KEY_CONVERTER_CLASS_CONFIG, "org.apache.kafka.connect.json.JsonConverter");
	workerProp.put(DistributedConfig.VALUE_CONVERTER_CLASS_CONFIG, "org.apache.kafka.connect.json.JsonConverter");
	workerProp.put(DistributedConfig.OFFSET_COMMIT_INTERVAL_MS_DEFAULT, 5000);

	workerProp.put(DistributedConfig.OFFSET_COMMIT_INTERVAL_MS_DEFAULT, 5000);
	workerProp.put(DistributedConfig.INTERNAL_KEY_CONVERTER_CLASS_CONFIG,
		"org.apache.kafka.connect.json.JsonConverter");
	workerProp.put(DistributedConfig.INTERNAL_VALUE_CONVERTER_CLASS_CONFIG,
		"org.apache.kafka.connect.json.JsonConverter");
	workerProp.put("key.converter.schemas.enable", "false");
	workerProp.put("value.converter.schemas.enable", "false");
	workerProp.put("internal.key.converter.schemas.enable", "false");
	workerProp.put("internal.value.converter.schemas.enable", "false");
	return new ConnectEmbedded(workerProp, connectProp);

    }

}

/*
 * connectProp.put(JdbcSourceConnector.CONNECTION_URL_CONFIG,
 * "jdbc:mysql://127.0.0.1:3306/bigData?user=root&password=root");
 * connectProp.put(JdbcSourceConnectorConfig.TIMESTAMP_COLUMN_NAME_DEFAULT,
 * "modified");
 * connectProp.put(JdbcSourceConnectorConfig.MODE_TIMESTAMP_INCREMENTING, "id");
 * connectProp.put(JdbcSourceConnectorConfig.INCREMENTING_COLUMN_NAME_DEFAULT,
 * "id");
 * connectProp.put(JdbcSourceConnectorConfig.TABLE_POLL_INTERVAL_MS_DEFAULT,
 * 10000); connectProp.put(JdbcSourceConnectorConfig.TOPIC_PREFIX_CONFIG,
 * "test-mysql-jdbc-");
 * connectProp.put(JdbcSourceConnectorConfig.BATCH_MAX_ROWS_DEFAULT, 10);
 * connectProp.put(JdbcSourceConnectorConfig.MODE_CONFIG, "mode");
 * connectProp.put(JdbcSourceConnectorConfig.MODE_TIMESTAMP_INCREMENTING,
 * "timestamp+incrementing"); connectProp.put(JdbcSourceConnectorConfig.
 * TIMESTAMP_DELAY_INTERVAL_MS_DEFAULT, 10000);
 * connectProp.put(JdbcSourceConnectorConfig.POLL_INTERVAL_MS_CONFIG, 5000);
 * connectProp.put(JdbcSourceConnectorConfig.TABLE_WHITELIST_DEFAULT, 5000);
 */

/*
 * connectProp.put(ConnectorConfig.NAME_CONFIG,
 * "test-source-mysql-jdbc-autoincrement");
 * connectProp.put(ConnectorConfig.CONNECTOR_CLASS_CONFIG,
 * "io.debezium.connector.mysql.MySqlConnector");
 * connectProp.put(ConnectorConfig.TASKS_MAX_CONFIG, "2");
 * connectProp.put(MySqlConnectorConfig.HOSTNAME, "mysql");
 * connectProp.put(MySqlConnectorConfig.PORT, 3306);
 * connectProp.put(MySqlConnectorConfig.USER, "root");
 * connectProp.put(MySqlConnectorConfig.PASSWORD, "root");
 * connectProp.put(MySqlConnectorConfig.HOSTNAME, "mysql");
 * connectProp.put(MySqlConnectorConfig.HOSTNAME, "mysql");
 * connectProp.put(JdbcSourceConnectorConfig.TIMESTAMP_COLUMN_NAME_DEFAULT,
 * "modified");
 * connectProp.put(JdbcSourceConnectorConfig.MODE_TIMESTAMP_INCREMENTING, "id");
 * connectProp.put(JdbcSourceConnectorConfig.INCREMENTING_COLUMN_NAME_DEFAULT,
 * "id");
 * connectProp.put(JdbcSourceConnectorConfig.TABLE_POLL_INTERVAL_MS_DEFAULT,
 * 10000); connectProp.put(JdbcSourceConnectorConfig.TOPIC_PREFIX_CONFIG,
 * "test-mysql-jdbc-");
 * connectProp.put(JdbcSourceConnectorConfig.BATCH_MAX_ROWS_DEFAULT, 10);
 * connectProp.put(JdbcSourceConnectorConfig.MODE_CONFIG, "mode");
 * connectProp.put(JdbcSourceConnectorConfig.MODE_TIMESTAMP_INCREMENTING,
 * "timestamp+incrementing"); connectProp.put(JdbcSourceConnectorConfig.
 * TIMESTAMP_DELAY_INTERVAL_MS_DEFAULT, 10000);
 * connectProp.put(JdbcSourceConnectorConfig.POLL_INTERVAL_MS_CONFIG, 5000);
 * connectProp.put(JdbcSourceConnectorConfig.TABLE_WHITELIST_DEFAULT, 5000);
 */