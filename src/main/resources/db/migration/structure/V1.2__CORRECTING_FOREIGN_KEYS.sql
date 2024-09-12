ALTER TABLE `socialmedia`.`message`
    DROP FOREIGN KEY `message_ibfk_1`,
    DROP FOREIGN KEY `message_ibfk_2`;
ALTER TABLE `socialmedia`.`message`
    ADD CONSTRAINT `message_ibfk_1`
    FOREIGN KEY (`sender_id`)
    REFERENCES `socialmedia`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    ADD CONSTRAINT `message_ibfk_2`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `socialmedia`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE `socialmedia`.`post`
  DROP FOREIGN KEY `post_ibfk_1`;
ALTER TABLE `socialmedia`.`post`
    ADD CONSTRAINT `post_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `socialmedia`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE `socialmedia`.`ulike`
DROP FOREIGN KEY `ulike_ibfk_1`,
DROP FOREIGN KEY `ulike_ibfk_2`,
DROP FOREIGN KEY `ulike_ibfk_3`;
ALTER TABLE `socialmedia`.`ulike`
ADD CONSTRAINT `ulike_ibfk_1`
  FOREIGN KEY (`post_id`)
  REFERENCES `socialmedia`.`post` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `ulike_ibfk_2`
  FOREIGN KEY (`comment_id`)
  REFERENCES `socialmedia`.`comment` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `ulike_ibfk_3`
  FOREIGN KEY (`user_id`)
  REFERENCES `socialmedia`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `socialmedia`.`friendship`
DROP FOREIGN KEY `friendship_ibfk_1`,
DROP FOREIGN KEY `friendship_ibfk_2`;
ALTER TABLE `socialmedia`.`friendship`
ADD CONSTRAINT `friendship_ibfk_1`
  FOREIGN KEY (`user_one_id`)
  REFERENCES `socialmedia`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `friendship_ibfk_2`
  FOREIGN KEY (`user_two_id`)
  REFERENCES `socialmedia`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `socialmedia`.`comment`
DROP FOREIGN KEY `comment_ibfk_1`,
DROP FOREIGN KEY `comment_ibfk_2`;
ALTER TABLE `socialmedia`.`comment`
CHANGE COLUMN `user_id` `user_id` INT NULL ;
ALTER TABLE `socialmedia`.`comment`
ADD CONSTRAINT `comment_ibfk_1`
  FOREIGN KEY (`post_id`)
  REFERENCES `socialmedia`.`post` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `comment_ibfk_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `socialmedia`.`user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;



