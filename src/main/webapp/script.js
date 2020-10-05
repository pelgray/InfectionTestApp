var app = new Vue({
    el: '#app',
    data: {
        buttonLabel: 'Добавить',
        virusType: [
            { text: 'РНК', value: 0 },
            { text: 'ДНК', value: 1 },
            { text: 'Ретровирус', value: 2 }
        ],
        input: {
            name: '',
            type: null,
            transmission: null,
            lifeExpAfterInfection: null,
            mortality: null,
            reInfection: null
        }
    },
    methods: {
        submitVirus: function () {
            try {
                this.buttonLabel = "Ожидание...";

                var requestOptions = {
                    method: 'POST',
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(this.input),
                    redirect: 'follow'
                };

                fetch("http://localhost:8787/api/viruses/add", requestOptions)
                    .then(response => console.log(response.text()))
                    .then(result => console.log(result))
                    .catch(error => console.log('error', error));

                this.input = {
                    name: '',
                    type: null,
                    transmission: null,
                    lifeExpAfterInfection: null,
                    mortality: null,
                    reInfection: null
                }
            } finally {
                this.buttonLabel = "Добавить";
            }
        }
    }
})
