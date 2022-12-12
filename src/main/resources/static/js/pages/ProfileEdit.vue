<template>
  <div class="d-flex align-center flex-column pt-10">
    <v-card width=50% class="px-10 py-10" rounded="lg" >
      <v-card-title prepend-icon="edit"><v-icon icon="edit" color="primary" class="mx-2"/>Редактирование личных данных</v-card-title>
      <v-card-item>
        <v-text-field label="Имя" variant="outlined" name="name" v-model="profile.name" class="pt-2"/>
        <v-text-field label="Электронная почта" variant="outlined" name="email" disabled v-model="profile.email"/>
        <v-text-field label="Телефон" variant="outlined" name="number" v-model="profile.number"/>
        <v-text-field label="Адрес" variant="outlined" v-model="profile.address"/>
      </v-card-item>
      <v-card-actions>
        <v-btn rounded="lg" variant="tonal" color="primary">Сохранить</v-btn>
        <v-btn rounded="lg" @click="$router.go(-1)">Отмена</v-btn>
      </v-card-actions>
    </v-card>
  </div>

</template>

<script>
import {computed} from "vue";

export default {
  name: "ProfileEdit",
  computed: {
    profile() {
      return this.$store.state.profile
    },


  },

}
</script>

<style scoped>

</style>