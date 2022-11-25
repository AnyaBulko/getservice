// const {createApp} = Vue
const instance = axios.create({
    baseURL: 'http://localhost:8080/'
});

// const UsersList = {
//     template: '<div>List11</div>'
// }

// Создаём Vue-приложение
const app = Vue.createApp({
    template: '<users-list :users="users" />',
    data() {
        return {
            users: []
        }
    }

    // Остальные свойства для компонента
})

app.component('users-list', {
    props: ['users'],
    template: '<div>' +
        '<user-item v-for="user in users" :user="user"></user-item>' +
        '</div>',
    created: function () {
        instance.get('/users').then(response => response.data.forEach(user => this.users.push(user))
        )
    }
})

app.component('user-item', {
    props: ['user'],
    template: '<div><i>{{ user.id }}</i> {{user.name}}</div>'
})

// Монтируем приложение Vue
app.mount('#app')

