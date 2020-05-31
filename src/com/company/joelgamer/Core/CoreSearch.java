package com.company.joelgamer.Core;

import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

import java.util.ArrayList;

public class CoreSearch {

    protected final CoreStorage coreStorage;

    public CoreSearch(CoreStorage coreStorage){
        this.coreStorage = coreStorage;
    }

    public Class searchClass(String name) throws ObjectNotFound {
        ArrayList<Class> classes = coreStorage.getClasses();
        for(Class aClass : classes){
            if(aClass.getName().contains(name)) return aClass;
        }
        throw new ObjectNotFound("Não existe nenhuma turma com esse nome!");
    }

    public Course searchCourse(String name) throws ObjectNotFound {
        ArrayList<Course> courses = coreStorage.getCourses();
        for(Course course : courses) {
            if(course.getName().contains(name)) return course;
        }
        throw new ObjectNotFound("Não existe nenhum curso com esse nome!");
    }

    public GraduateStudent searchGraduateStudent(String name) throws ObjectNotFound {
        ArrayList<GraduateStudent> graduateStudents = coreStorage.getGraduateStudents();
        for(GraduateStudent graduateStudent : graduateStudents){
            if(graduateStudent.getName().contains(name)) return graduateStudent;
        }
        throw new ObjectNotFound("Não existe nenhum aluno(a) com esse nome!");
    }

    public PostGraduateStudent searchPostGraduateStudent(String name) throws ObjectNotFound {
        ArrayList<PostGraduateStudent> postGraduateStudents = coreStorage.getPostGraduateStudents();
        for(PostGraduateStudent postGraduateStudent : postGraduateStudents) {
            if(postGraduateStudent.getName().contains(name)) return postGraduateStudent;
        }
        throw new ObjectNotFound("Não nenhum aluno(a) pós graduado(a) com esse nome!");
    }

    public Object searchSpecificStudent(String name) throws ObjectNotFound {
        for(GraduateStudent graduateStudent : coreStorage.getGraduateStudents()) {
            if(graduateStudent.getName().equalsIgnoreCase(name)) return graduateStudent;
        }

        for(PostGraduateStudent postGraduateStudent : coreStorage.getPostGraduateStudents()) {
            if(postGraduateStudent.getName().equalsIgnoreCase(name)) return postGraduateStudent;
        }

        throw new ObjectNotFound("Desculpe, mas não existe esse aluno cadastrado, confere com algum professor se você está cadastrado.");
    }

    public Professor searchProfessor(String name) throws ObjectNotFound {
        ArrayList<Professor> professors = coreStorage.getProfessors();
        for(Professor professor : professors){
            if(professor.getName().contains(name)) return professor;
        }
        throw new ObjectNotFound("Não existe nenhum professor com esse nome!");
    }

    public Question searchQuestion(String title) throws ObjectNotFound {
        ArrayList<Question> questions = coreStorage.getQuestions();
        for(Question question : questions){
            if(question.getTitle().contains(title)) return question;
        }
        throw new ObjectNotFound("Não existe nenhuma questão com esse nome!");
    }

    public Quiz searchQuiz(String name) throws ObjectNotFound {
        ArrayList<Quiz> quizzes = coreStorage.getQuizzes();
        for(Quiz quiz : quizzes){
            if(quiz.getName().contains(name)) return quiz;
        }
        throw new ObjectNotFound("Não existe nenhum quiz com esse nome!");
    }

    public ArrayList<Quiz> searchQuizzesForStudent(Class aClass) throws ObjectNotFound {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        for(Quiz quiz : coreStorage.getQuizzes()) {
            if(quiz.getClasses().contains(aClass)) quizzes.add(quiz);
        }

        if(quizzes.isEmpty()) throw new ObjectNotFound("Infelizmente não tem nenhum quiz para você responder.");
        return quizzes;
    }

    public University searchUniversity(String name) throws ObjectNotFound {
        ArrayList<University> universities = coreStorage.getUniversities();
        for(University university : universities) {
            if(university.getName().contains(name)) return university;
        }
        throw new ObjectNotFound("Não existe nenhuma universidade com esse nome!");
    }
}
