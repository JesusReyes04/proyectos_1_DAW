drop database twitter_db;
create database twitter_db;
use twitter_db;

drop table if exists users;
create table users (
	user_id int not null auto_increment,
    user_handle varchar(50) not null unique,
    email_address varchar(50) not null unique,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    phonenumber varchar(10) unique,
    created_at timestamp not null default(now()),
    primary key(user_id)
);
# el user_id es el único atributo que no es nulo, es único para cada usuario, e inmutable 

# vamos a normalizar la relación de users consigo mismo para los seguidores porque es N a N y podemos quitarle complejidad a la tabla users haciendo esta normalización

drop table if exists followers;
create table followers(
	follower_id int not null,  										# la persona que sigue 
    following_id int not null,  									# el famoso
    primary key(follower_id,following_id),
    foreign key (follower_id) references users(user_id),
    foreign key (following_id) references users(user_id)
);

# de cara a futuros inserts no hagas el bobo intentando hacer que sergio ramos con id 2 siga a bob esponja con id 500 si solo tenemos 60 ids en la tabla, va a dar error
# luego hay que hacer que una cuenta no pueda seguirse a sí mismo, se puede hacer con un constraint pero voy a hacerlo con un trigger

DELIMITER //
create trigger comprobar_follow
before insert on followers
for each row
begin
	declare message_text varchar(255);
	if new.follower_id = new.following_id then
    set message_text = 'Un usuario no puede seguirse a si mismo';
    signal sqlstate '45000' set message_text = message_text;
    end if;
end;
// DELIMITER ;

drop table if exists tweets;
create table tweets (
	tweet_id int not null auto_increment,
    user_id int not null,
    tweet_text varchar(280) not null,
    num_likes int default 0,
    num_retweet int default 0,
    num_comments int default 0,
    created_at timestamp not null default(now()),
    foreign key (user_id) references users (user_id),
    primary key (tweet_id)
);
