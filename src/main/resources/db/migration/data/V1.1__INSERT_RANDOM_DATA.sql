INSERT INTO `user` (username, password, first_name, last_name, bio) VALUES
('alice', 'password123', 'Alice', 'Smith', 'Bio of Alice Smith.'),
('bob', 'password456', 'Bob', 'Johnson', 'Bio of Bob Johnson.'),
('carol', 'password789', 'Carol', 'Williams', 'Bio of Carol Williams.'),
('dave', 'password012', 'Dave', 'Brown', 'Bio of Dave Brown.'),
('eve', 'password345', 'Eve', 'Davis', 'Bio of Eve Davis.');

INSERT INTO `post` (user_id, content) VALUES
(1, 'Alice\'s first post.'),
(2, 'Bob is enjoying the sunny weather.'),
(3, 'Carol shares a fun fact.'),
(4, 'Dave talks about his new project.'),
(5, 'Eve posts a motivational quote.');

INSERT INTO `comment` (post_id, user_id, content) VALUES
(1, 2, 'Great post, Alice!'),
(1, 3, 'I agree, very interesting.'),
(2, 1, 'Indeed, the weather is lovely.'),
(3, 4, 'Thanks for the fun fact, Carol!'),
(4, 5, 'Looking forward to hearing more about your project.'),
(5, 3, 'Love the quote, Eve!');

INSERT INTO `friendship` (user_one_id, user_two_id) VALUES
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(1, 5);

INSERT INTO `ulike` (post_id, comment_id, user_id) VALUES
(1, NULL, 2),
(2, NULL, 3),
(3, 1, 4),
(4, NULL, 5),
(5, 2, 1);
