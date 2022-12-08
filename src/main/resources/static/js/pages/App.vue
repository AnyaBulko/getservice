<template>
  <div>11</div>
  <div>
    <div v-if="!profile"> Необходимо авторизоваться <a href="/auth/login"> здесь</a></div>
    <div v-else>
      <div>{{ profile.username }}</div>
      <user-list :users="users"/>
      <form action="/auth/logout" method="POST">
        <button type="submit">Выйти</button>
      </form>
    </div>
  </div>

</template>

<script>
import UserList from "../components/UserList.vue";

export default {
  components: {
    UserList
  },
  data() {
    return {
      users: frontendData.users,
      profile: frontendData.profile
    }
  }
}
</script>

<style>

</style>
