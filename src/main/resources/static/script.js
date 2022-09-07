
$(document).ready(() => {

    $('#tabela').DataTable({
        serverSide: true,
        ajax: {
            type: 'post',
            url: '/funcionarios/all',
            contentType: 'application/json',
            data: data => JSON.stringify(data),
        },
        columns: [
            { data: 'idFuncionario' },
            { data: 'nome' },
            { data: 'sobrenome' },
            { data: 'sexo' },
            { data: 'dataNasc' },
            { data: 'dataAdmissao' },
        ],
    });
    
});
