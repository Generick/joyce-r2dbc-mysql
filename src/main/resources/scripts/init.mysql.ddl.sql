
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
       `user_id` int(11) NOT NULL AUTO_INCREMENT,
       `username` varchar(255) COLLATE utf8mb4_bin NOT NULL,
       `age` int(3) NOT NULL,
       `birthday_date_time` datetime NOT NULL,
       `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
       `create_date_time` datetime NOT NULL,
       PRIMARY KEY (`user_id`) USING BTREE,
       UNIQUE KEY `unique_username` (`username`) USING BTREE,
       KEY `idx_remark` (`remark`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=921 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders` (
        `order_id` int(11) NOT NULL AUTO_INCREMENT,
        `user_id` int(11) NOT NULL,
        `order_amount` decimal(9,2) NOT NULL,
        `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
        `create_date_time` datetime DEFAULT NULL,
        PRIMARY KEY (`order_id`) USING BTREE,
        KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;




