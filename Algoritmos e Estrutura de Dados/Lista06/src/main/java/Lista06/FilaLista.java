    package Lista06;

    import java.util.ArrayList;
    import java.util.List;

    public class FilaLista<T> implements Fila<T> {

        private ListaEncadeada<T> lista = new ListaEncadeada<T>();

        /**
         * Insere um elemento na fila
         */
        @Override
        public void inserir(T valor) {
            lista.inserirNoFinal(valor);
        }

        /**
         * Avalia se a lista esta vazia
         */
        @Override
        public boolean estaVazia() {
            return lista.estaVazia();
        }

        /**
         * Retorna o elemento que esta no inicio da fila
         *
         * @return Dado que esta no inicio da fila
         */
        @Override
        public T peek() {
            if (estaVazia()) {
                throw new FilaVaziaException();
            }

            return (T) lista.getPrimeiro().getInfo();
        }

        /**
         * Retira um elemento da fila
         */
        @Override
        public T retirar() {
            T valor = peek();
            lista.retirar(valor);

            return valor;
        }

        /**
         * Retira todos os elementos da fila
         */
        @Override
        public void liberar() {
            lista = new ListaEncadeada<T>();
        }

        /**
         * Retorna uma representacao textual da fila, partindo do inicio ate o final. Os dados sao separados por virgula
         *
         * @return Conteudo da fila
         */
        @Override
        public String toString() {
            return lista.toString();
        }

        /**
         * Conta quantas vezes um determinado valor aparece na fila.
         *
         * @param valor Valor a ser contado na fila.
         * @return Número de ocorrências do valor na fila.
         */
        public int contarOcorrencias(T valor) {
            int contador = 0;
            NoLista<T> atual = lista.getPrimeiro();

            while (atual != null) {
                if (atual.getInfo().equals(valor)) {
                    contador++;
                }
                atual = atual.getProximo();
            }

            return contador;
        }

        /**
         * Intercala os elementos da fila atual com os de outra fila passada por parâmetro.
         * O resultado da intercalação substitui o conteúdo da fila atual.
         *
         * @param outra Outra fila a ser intercalada.
         */
        public void intercalarCom(FilaLista<T> outra) {
            FilaLista<T> resultado = new FilaLista<>();

            while (!this.estaVazia() || !outra.estaVazia()) {
                if (!this.estaVazia()) {
                    resultado.inserir(this.retirar());
                }
                if (!outra.estaVazia()) {
                    resultado.inserir(outra.retirar());
                }
            }

            while (!resultado.estaVazia()) {
                this.inserir(resultado.retirar());
            }
        }

        /**
         * Remove elementos duplicados da fila, mantendo apenas a primeira ocorrência de cada valor.
         */
        public void removerDuplicados() {
            FilaLista<T> auxiliar = new FilaLista<>();
            List<T> vistos = new ArrayList<>();

            while (!estaVazia()) {
                T valor = retirar();
                if (!vistos.contains(valor)) {
                    vistos.add(valor);
                    auxiliar.inserir(valor);
                }
            }

            while (!auxiliar.estaVazia()) {
                inserir(auxiliar.retirar());
            }
        }

        /**
         * Compara esta fila com outra fila passada por parâmetro.
         * Retorna true se ambas tiverem os mesmos elementos na mesma ordem.
         *
         * @param outra Outra fila a ser comparada.
         * @return true se as filas forem iguais; false caso contrário.
         */
        public boolean compararFilas(FilaLista<T> outra) {
            FilaLista<T> f1Aux = new FilaLista<>();
            FilaLista<T> f2Aux = new FilaLista<>();
            boolean iguais = true;

            while (!this.estaVazia() && !outra.estaVazia()) {
                T val1 = this.retirar();
                T val2 = outra.retirar();

                if (!val1.equals(val2)) {
                    iguais = false;
                }

                f1Aux.inserir(val1);
                f2Aux.inserir(val2);
            }

            if (!this.estaVazia() || !outra.estaVazia()) {
                iguais = false;
            }

            while (!f1Aux.estaVazia()) {
                this.inserir(f1Aux.retirar());
            }
            while (!f2Aux.estaVazia()) {
                outra.inserir(f2Aux.retirar());
            }

            return iguais;
        }

        /**
         * Verifica se a fila contém o valor especificado.
         *
         * @param valor Valor a ser buscado.
         * @return true se o valor estiver presente; false caso contrário.
         */
        public boolean contem(T valor) {
            NoLista<T> atual = lista.getPrimeiro();

            while (atual != null) {
                if (atual.getInfo().equals(valor)) {
                    return true;
                }
                atual = atual.getProximo();
            }

            return false;
        }

        /**
         * Inverte a ordem dos elementos da fila.
         */
    //    public void inverterFila() {
    //        PilhaLista<T> pilha = new PilhaLista<>();
    //        while (!estaVazia()) {
    //            pilha.push(retirar());
    //        }
    //        while (!pilha.estaVazia()) {
    //            inserir(pilha.pop());
    //        }
    //    }
    }
