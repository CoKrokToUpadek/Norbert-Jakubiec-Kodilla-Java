INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, 'added post NO.1');

INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, 'added post NO.2');

INSERT INTO POSTS (USER_ID, BODY)
VALUES (1, 'added post NO.3');

COMMIT ;

SELECT * FROM POSTS;

UPDATE POSTS
SET BODY='TO DELETE'
WHERE ID=7;

UPDATE POSTS
SET BODY='TO DELETE'
WHERE ID=8;

UPDATE POSTS
SET BODY='TO DELETE'
WHERE ID=9;

COMMIT;

SELECT * FROM POSTS;


DELETE FROM POSTS
WHERE ID=7;

DELETE FROM POSTS
WHERE ID=8;

DELETE FROM POSTS
WHERE ID=9;

COMMIT;

SELECT * FROM POSTS;