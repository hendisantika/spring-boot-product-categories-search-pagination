--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `description`, `is_active`, `name`, `category_id`) VALUES (1,'Buku Sinar Dunia',_binary '\0','Buku Sinar Dunia',1),(2,'Minyak Filma',_binary '\0','Minyak Filma',2),(52,'Pulpen Pilot',_binary '\0','Pulpen Pilot',1),(53,'Beras Rojo Lele',_binary '\0','Beras Rojo Lele',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
