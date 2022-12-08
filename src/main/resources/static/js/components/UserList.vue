<template>
  <div>
    <div v-for="user in users">
      <i>{{ user.id }}</i> {{ user.name }}
      {{ user.role }} {{ user.number }} {{ user.registrationDate }}
      {{ user.email }}
    </div>
  </div>
</template>

<script>
export default {
  name: "UserList",
  props: ['users']
}
</script>

<style scoped>

</style>