BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "pessoas" (
	"id"	INTEGER NOT NULL UNIQUE,
	"prenome"	TEXT NOT NULL,
	"nome"	TEXT,
	"sobrenome"	TEXT NOT NULL,
	"telefone"	TEXT,
	"cpf"	TEXT NOT NULL UNIQUE,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "alunos" (
	"fk_pessoa"	INTEGER UNIQUE,
	"codigo_matricula"	INTEGER NOT NULL,
	FOREIGN KEY("fk_pessoa") REFERENCES "pessoas"("id")
);
CREATE TABLE IF NOT EXISTS "professores" (
	"fk_pessoa"	INTEGER NOT NULL UNIQUE,
	"codigo_matricula"	INTEGER NOT NULL,	
	FOREIGN KEY("fk_pessoa") REFERENCES "pessoas"("id")
);
CREATE TABLE IF NOT EXISTS "cursos" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nome"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "disciplinas" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nome"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "contratos" (
	"id"	INTEGER NOT NULL UNIQUE,
	"fk_aluno"	INTEGER NOT NULL,
	"fk_curso"	INTEGER NOT NULL,
	"data_ativacao"	TEXT NOT NULL,
	"data_desativacao"	TEXT,
	PRIMARY KEY("id"),
	FOREIGN KEY("fk_curso") REFERENCES "cursos"("id"),
	FOREIGN KEY("fk_aluno") REFERENCES "alunos"("id")
);
CREATE TABLE IF NOT EXISTS "periodos" (
	"id"	INTEGER NOT NULL UNIQUE,
	"periodo_letivo"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "turmas" (
	"id"	INTEGER NOT NULL UNIQUE,
	"fk_professor"	INTEGER NOT NULL,
	"fk_disciplina"	INTEGER NOT NULL,
	"fk_periodo"	INTEGER NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY("fk_disciplina") REFERENCES "disciplinas"("id"),
	FOREIGN KEY("fk_periodo") REFERENCES "periodos"("id"),
	FOREIGN KEY("fk_professor") REFERENCES "professores"("id")
);
CREATE TABLE IF NOT EXISTS "matriculas" (
	"id"	INTEGER NOT NULL UNIQUE,
	"fk_contrato"	INTEGER NOT NULL,
	"fk_turma"	INTEGER NOT NULL,
	"data_matricula"	TEXT NOT NULL,
	"data_encerramento"	TEXT,
	"nota1"	REAL,
	"nota2"	REAL,
	"nota3"	REAL,
	"nota_final"	REAL,
	PRIMARY KEY("id"),
	FOREIGN KEY("fk_turma") REFERENCES "turmas"("id"),
	FOREIGN KEY("fk_contrato") REFERENCES "contratos"("id")
);
COMMIT;
