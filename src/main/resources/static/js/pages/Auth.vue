<template>

  <div class="d-flex align-center flex-column pt-10">
    <v-card width="400" class="px-10 py-4" rounded="lg">
      <template v-slot:prepend>
        <v-icon color="primary" icon="person_outline" size="large"/>
      </template>
      <template v-slot:title>
        <h3>Вход в аккаунт</h3>
      </template>
      <v-divider class="pb-5"></v-divider>
      <form method="post" class=""
      >
        <v-text-field label="Электронная почта" name="username" variant="outlined"></v-text-field>
        <v-text-field label="Пароль" name="password" type="password" variant="outlined"></v-text-field>
        <v-divider/>
        <v-card-actions class="py-5">
          <v-btn block type="submit" color="primary" variant="flat" append-icon="navigate_next" rounded="lg" >  Войти </v-btn>
        </v-card-actions>

      </form>
    </v-card>
  </div>


</template>

<script>
export default {
  name: "Auth",
  data: () => ({
    username: '',
    password: ''
  })
}
</script>

<style scoped>

</style>