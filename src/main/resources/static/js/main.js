// const {createApp} = Vue
const instance = axios.create({
    baseURL: 'http://localhost:8080/api'
});

// Создаём Vue-приложение
const app = Vue.createApp({
    template: '<div><div v-if="!profile"> Необходимо авторизоваться <a href="/auth/login"> здесь</a></div>' +
        '<users-list v-else :users="users" />' +
        '</div>' +
        '<div v-if="profile">' +
        '<div>{{profile.username}}</div>' +
        '    <form action="/auth/logout" method="POST">\n' +
        '        <button type="submit">Выйти</button>\n' +
        '    </form>' +
        '</div>',
    data() {
        return {
            users: frontendData.users,
            profile: frontendData.profile,
            test: null
        }
    },
    created: function () {
        //instance.get('api/users').then(response => response.data.forEach(user => this.users.push(user)))
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

