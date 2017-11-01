-- auto Generated on 2017-10-25 10:53:32 
-- DROP TABLE IF EXISTS `role`; 
CREATE TABLE `role`(
    `role_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'roleName',
    `auth` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'auth',
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `created_at` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createdAt',
    `updated_at` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'updatedAt',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`role`';
