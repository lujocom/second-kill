CREATE TABLE `second_kill` (
  `seckill_id` varchar(32) NOT NULL COMMENT '商品库存id',
  `name` varchar(256) NOT NULL COMMENT '秒杀名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'

INSERT INTO
  second_kill(name, number, start_time, end_time)
VALUES
  ('1000秒杀iPhone6s', 200, '2017-03-18 00:00:00','2017-03-19 00:00:00'),
  ('900秒杀iPad4', 300, '2017-03-18 00:00:00','2017-03-19 00:00:00'),
  ('3000秒杀Mac Pro', 100, '2017-03-18 00:00:00','2017-03-19 00:00:00'),
  ('300秒杀红米Note', 400, '2017-03-18 00:00:00','2017-03-19 00:00:00')

CREATE TABLE `success_kill` (
  `seckill_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '库存id',
  `user_phone` varchar(13) COLLATE utf8_bin NOT NULL COMMENT '秒杀的用户',
  `state` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '-1表示无效，0表示成功,1表示已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='秒杀成功明细表'