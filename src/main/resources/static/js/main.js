// const {createApp} = Vue
const instance = axios.create({
    baseURL: 'http://localhost:8080/api'
});

// const UsersList = {
//     template: '<div>List11</div>'
// }

// Создаём Vue-приложение
const app = Vue.createApp({
    template: '<div><users-list :users="users" />' +
        '<div v-if="!profile">Необходимо авторизоваться <a  href="/login">здесь</a></div></div>',
    data() {
        return {
            users: [],
            profile: frontendData.profile
        }
    },
    created: function () {
        // instance.get('api/users').then(response => response.data.forEach(user => this.users.push(user)))
    }

    // Остальные свойства для компонента
})

app.component('users-list', {
    props: ['users'],
    template: '<div>' +
        '<user-item v-for="user in users" :user="user"></user-item>' +
        '</div>',

})

app.component('user-item', {
    props: ['user'],
    template: '<div><i>{{ user.id }}</i> {{user.name}}</div>',

})

// Монтируем приложение Vue
app.mount('#app')

