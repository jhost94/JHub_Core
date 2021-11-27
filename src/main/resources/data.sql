LOCK TABLES `soc_annual_invoice_range` WRITE;
/*!40000 ALTER TABLE `soc_annual_invoice_range` DISABLE KEYS */;
INSERT IGNORE INTO `soc_annual_invoice_range` VALUES (1,'1000 - 10000'),(3,'100001 - 1000000'),(2,'10001 - 100000');
/*!40000 ALTER TABLE `soc_annual_invoice_range` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_currency` WRITE;
/*!40000 ALTER TABLE `soc_currency` DISABLE KEYS */;
INSERT IGNORE INTO `soc_currency` VALUES (1,'Euro','EU'),(2,'Colombian Pesos','COP'),(3,'Dollar','US');
/*!40000 ALTER TABLE `soc_currency` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_hear_about_us` WRITE;
/*!40000 ALTER TABLE `soc_hear_about_us` DISABLE KEYS */;
INSERT IGNORE INTO `soc_hear_about_us` VALUES (3,TRUE, 'Email'),(2,TRUE,'Google'),(4,TRUE, 'Referido'),(1,TRUE,'Website');
/*!40000 ALTER TABLE `soc_hear_about_us` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_industry` WRITE;
/*!40000 ALTER TABLE `soc_industry` DISABLE KEYS */;
INSERT IGNORE INTO `soc_industry` VALUES (1,'Tecnologia'),(2,'Servicios'),(3,'Agropecuaria'),(4,'Banca');
/*!40000 ALTER TABLE `soc_industry` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_region` WRITE;
/*!40000 ALTER TABLE `soc_region` DISABLE KEYS */;
INSERT IGNORE INTO `soc_region` VALUES (1,'Europa'),(2,'Asia'),(3,'Africa'),(4,'America');
/*!40000 ALTER TABLE `soc_region` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_number_of_employees` WRITE;
/*!40000 ALTER TABLE `soc_number_of_employees` DISABLE KEYS */;
INSERT IGNORE INTO `soc_number_of_employees` VALUES (1,'1 - 10'),(4,'101 - 500'),(2,'11- 50'),(5,'501+'),(3,'51 - 100');
/*!40000 ALTER TABLE `soc_number_of_employees` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_user` WRITE;
/*!40000 ALTER TABLE `soc_user` DISABLE KEYS */;
INSERT IGNORE INTO `soc_user` VALUES (15,'2021-10-29 00:41:51','test1@soc.eu', TRUE, 'Test 1','$2a$10$UkO73TuQ.V2oc11EA8ltUO4346QI3xHuMrDDjd3F6Bic5tQ8QKoWW',FALSE,2,2,2,2,2,2), (16,'2021-10-29 00:41:51','test2@soc.eu', TRUE,'Test 2','$2a$10$UkO73TuQ.V2oc11EA8ltUO4346QI3xHuMrDDjd3F6Bic5tQ8QKoWW',FALSE,2,2,2,2,2,2), (17,'2021-10-29 00:41:51','test3@soc.eu', TRUE,'Test 3','$2a$10$UkO73TuQ.V2oc11EA8ltUO4346QI3xHuMrDDjd3F6Bic5tQ8QKoWW',FALSE,2,2,2,2,2,2);
/*!40000 ALTER TABLE `soc_user` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `soc_target_type` WRITE;
/*!40000 ALTER TABLE `soc_target_type` DISABLE KEYS */;
INSERT IGNORE INTO `soc_target_type` VALUES (1, TRUE, "Response time reduction"), (2, TRUE, "Get rid of waste"), (3, TRUE, "Boost gross margin"), (4, TRUE, "Give repetitive tasks to technology"), (5, TRUE, "With the same people produce 40% more"), (6, TRUE, "Increase Service reliability"), (7, TRUE, "My team does not accept change"), (8, TRUE, "Service specifications clarity"), (9, TRUE, "My team is not proactive"), (10, TRUE, "We do not get projects fully implemented");
/*!40000 ALTER TABLE `soc_target_type` ENABLE KEYS */;
UNLOCK TABLES;