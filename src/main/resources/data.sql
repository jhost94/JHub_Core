LOCK TABLES `core_user` WRITE;
/*!40000 ALTER TABLE `core_user` DISABLE KEYS */;
INSERT IGNORE INTO `core_user` (id, name, email, creation_date, password, is_active) VALUES (1, 'Test1', 'test1@jhub.eu', '2021-10-29 00:41:51', '$2a$10$UkO73TuQ.V2oc11EA8ltUO4346QI3xHuMrDDjd3F6Bic5tQ8QKoWW', TRUE);
/*!40000 ALTER TABLE `core_user` ENABLE KEYS */;
UNLOCK TABLES;