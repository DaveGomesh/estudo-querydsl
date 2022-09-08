package com.estudo.querydsl.repository.funcionario;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.estudo.querydsl.enumerate.Sexo;
import com.estudo.querydsl.filter2.IntegerFilter;
import com.estudo.querydsl.filter2.PredicateFactory;
import com.estudo.querydsl.model.Funcionario;
import com.estudo.querydsl.model.QFuncionario;
import com.estudo.querydsl.repository.filter.FuncionarioFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.Builder;

@Builder
public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

    private final JPAQueryFactory jpaQueryFactory;
    private final PredicateFactory predicateFactory;

    @Override
    public List<Funcionario> filtrar(FuncionarioFilter funcionarioFilter) {

        final QFuncionario qFuncionario = QFuncionario.funcionario;

        final Predicate filtros = criarFiltros(funcionarioFilter, qFuncionario);

        final JPAQuery<Funcionario> query = (jpaQueryFactory
            .select(qFuncionario)
            .from(qFuncionario)
            .where(filtros)
            // .where(qFuncionario.idFuncionario.gt())
            // .where(qFuncionario.nome.)
        );

        final List<Funcionario> listaFunc = query.fetch();
        return listaFunc;
    }

    private Predicate criarFiltros(FuncionarioFilter funcFilter, QFuncionario qFuncionario){

        final IntegerFilter integerFilter = funcFilter.getIdFuncionario();
        integerFilter.setNumberPath(qFuncionario.idFuncionario);

        final Predicate predicate = predicateFactory.createPredicate(integerFilter);
        final BooleanBuilder booleanBuilder = new BooleanBuilder();

        booleanBuilder.and(predicate);

        return predicate;
    }

    private void filtrarPorNome(String nome, StringPath pathNome, List<BooleanExpression> listaBoolExp){

        if(Objects.nonNull(nome)){
            listaBoolExp.add(pathNome.startsWith(nome));
        }
    }
    
    private void filtrarPorSobrenome(String sobrenome, StringPath pathSobrenome, List<BooleanExpression> listaBoolExp){

        if(Objects.nonNull(sobrenome)){
            listaBoolExp.add(pathSobrenome.startsWith(sobrenome));
        }
    }

    private void filtrarPorSexo(Sexo sexo, EnumPath<Sexo> pathSexo, List<BooleanExpression> listaBoolExp){

        if(Objects.nonNull(sexo)){
            listaBoolExp.add(pathSexo.eq(sexo));
        }
    }

    private void filtrarPorDataNasc(LocalDate dataNascInicial, LocalDate dataNascFinal, DatePath<LocalDate> pathDataNasc, List<BooleanExpression> listaBoolExp){

        if(Objects.nonNull(dataNascInicial)){

            if(Objects.nonNull(dataNascFinal)){
                listaBoolExp.add(pathDataNasc.between(dataNascInicial, dataNascFinal));
            }else{
                listaBoolExp.add(pathDataNasc.eq(dataNascInicial));
            }
        }
    }

    private void filtrarPorDataAdmissao(LocalDate dataAdmissaoInicial, LocalDate dataAdmissaoFinal, DatePath<LocalDate> pathDataAdmissao, List<BooleanExpression> listaBoolExp){

        if(Objects.nonNull(dataAdmissaoInicial)){

            if(Objects.nonNull(dataAdmissaoFinal)){
                listaBoolExp.add(pathDataAdmissao.between(dataAdmissaoInicial, dataAdmissaoFinal));
            }else{
                listaBoolExp.add(pathDataAdmissao.eq(dataAdmissaoInicial));
            }
        }
    }
}
