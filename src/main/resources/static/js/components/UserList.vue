<template>
  <v-table
      fixed-header
      height="">

    <thead>
    <tr>
      <th class="text-left">id</th>
      <th class="text-left">Имя</th>
      <th class="text-left">Мобильный номер</th>
      <th class="text-left">Email</th>
      <th class="text-left">Дата регистрации</th>
      <th class="text-left">Роль</th>
    </tr>
    </thead>

    <tbody>
    <tr
        v-for="user in users"
        :key="user.id"
    >
      <td>{{ user.id }}</td>
      <td>{{ user.name }}</td>
      <td>{{ user.number }}</td>
      <td>{{ user.email }}</td>
      <td>{{ user.registrationDate }}</td>
      <td>{{ user.role }}</td>
    </tr>
    </tbody>
  </v-table>
</template>

<script>
export default {
  name: "UserList",
  computed: {
    users() {
      return this.$store.state.users
    }
  }
}
</script>

<style scoped>

</style>