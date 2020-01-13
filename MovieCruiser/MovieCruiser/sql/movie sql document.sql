/*view Movie Admin*/
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Lifted', '27879650', 'Yes', '2017-03-15', 'Science fiction', 'Yes');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', 'Yes', '2017-12-23', 'Superhero', 'No');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', 'Yes', '2017-08-21', 'Romance', 'No');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', 'No', '2017-07-02', 'Science Fiction', 'Yes');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers:Eng Game', '2750760348', 'Yes', '2022-11-02', 'Superhero', 'Yes');

/*view Movie List Customer*/
use movie_cruiser;
INSERT INTO `movie_cruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Vijay');
INSERT INTO `movie_cruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajith');

/*view Movie List Customer*/
select * from movie_cruiser.movie_list
 where movie_list.mo_date_of_launch>'2020-01-03' and mo_active='Yes';

/*Edit Movie List*/
select * from movie_cruiser.movie_list where mo_id=1;
UPDATE `movie_cruiser`.`movie_list` SET `mo_id` = '5', `mo_title` = 'lifted', `mo_gross` = '345', `mo_active` = 'Yes', `mo_date_of_launch` = '2022-10-03', `mo_genre` = 'Action', `mo_has_teaser` = 'Yes' WHERE (`mo_id` = '5');

 /*Add to Favourites*/
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '1');
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '2');
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '3');
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '3');
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '4');
INSERT INTO `movie_cruiser`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '5');

/*View Favourites*/
use movie_cruiser;
SELECT movie_list.mo_title,movie_list.mo_has_teaser,movie_list.mo_gross from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/*View Favourites*/
SELECT user.us_id,count(*) as mo_fav from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/*Remove Favourites*/
SELECT movie_list.mo_title,movie_list.mo_has_teaser,movie_list.mo_gross from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;
delete from movie_cruiser.favourites where fv_us_id=2 and fv_gr_id=3;