CREATE TABLE produto (id SERIAL PRIMARY KEY,
					 descricao VARCHAR(255),
					  mangas VARCHAR(255),
					  consumotecido VARCHAR(255),
					  consumoaviamentos VARCHAR(255),
					  costureira VARCHAR(255),
					  acabamento VARCHAR(255),
					  faixasrefletivas VARCHAR(255),
					  golapunho VARCHAR(255),
					  sugestaopreco VARCHAR(255),
					  outrasdescricoes VARCHAR(255));
					  
CREATE TABLE usuario (id SERIAL PRIMARY KEY,
					 usuario VARCHAR(255),
					 senha VARCHAR(255));