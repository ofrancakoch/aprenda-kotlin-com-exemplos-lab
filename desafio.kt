enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val dificuldade: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {


    val inscritos = mutableListOf<Aluno>()
    
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
        println("Cadastro de ${aluno.nome} foi realizado com sucesso.")
    }

    fun visualizarCursos(){
        println("| Cursos Disponíveis na Formação ${this.nome} |\n")
        for(curso in conteudos){
            println("\t${curso.nome} | ${curso.duracao} | ${curso.dificuldade}\n")
        }
    }
    
    fun verificarInscritos(){
        println("\n| Inscritos na Formação ${this.nome} |")
        for (inscrito in inscritos){
            println(inscrito.nome)
        }
    }
    
 
}

fun main() {
   val aluno = Aluno("Edvan")
   val aluno2 = Aluno("Oswaldo")
   val cursos = listOf(
            ConteudoEducacional("Versionamento de Código com Git e GitHub", 82, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Aprendendo Python",75, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Dominando Kotlin", 90, Nivel.AVANCADO),
            ConteudoEducacional("Kotlin BackEnd", 23, Nivel.BASICO),
            ConteudoEducacional("Python e Django", 66, Nivel.AVANCADO),
            ConteudoEducacional("Estrutura de Dados em C", 40, Nivel.INTERMEDIARIO),
            ConteudoEducacional("Banco de Dados - SQL", 67, Nivel.BASICO),
        )
   
   val formacao = Formacao("BackEnd com Python e Kotlin", cursos)
   formacao.visualizarCursos()
   formacao.matricular(aluno)
   formacao.matricular(aluno2)
   formacao.verificarInscritos()
}