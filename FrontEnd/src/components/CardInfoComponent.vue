<script setup>
import { ref, onBeforeMount } from 'vue';
import { defineProps } from 'vue';
import CardInfoService from '../services/CardInfoService';

const props = defineProps({
    id: {
        type: Number,
        required: true
    }
});

const data = ref();
const loading = ref(true);
const userImage = ref(""); 

function getUserImageSrc(base64ImageData) {
    return `data:image/jpeg;base64,${base64ImageData}`;
}

async function getWorkerData() {
  loading.value = true;
  const response = await CardInfoService.getWorkerData(props.id);
  data.value = await response.data;
  userImage.value = data.value ? data.value.userImage : "";
  console.log(response.data);
  loading.value = false;
}

onBeforeMount(getWorkerData);

</script>

<template>
    <div class="card-container">
        <div class="image-container">
            <img class="card_info_img" v-if="data" :src="getUserImageSrc(data.userImage)" />
        </div>
        <div class="content-container">
            <ul class="ul-title">
                <li class="title">{{ data && data.username }}</li>
                <ul class="line2">
                    <li>
                        <img class="icon" src="public/role.png" />
                        {{ data && data.userType }}
                    </li>
                    <li>
                        <img class="icon" src="public/organigram.png" />
                        Dpto {{ data && data.userDept }}
                    </li>
                    <li>
                        <img class="icon" src="public/pin.png" />
                        {{ data && data.schoolID.schoolName }}
                    </li>
                </ul>
                <ul class="line3">
                    <li>
                        <img class="icon" src="public/start_date.png" />
                        Fecha de inicio: {{ data && data.userStartDate }}
                    </li>
                    <li>
                        <img class="icon" src="public/supervisor.png" />
                        Supervisor: {{ data && data.userType }}
                    </li>
                </ul>
            </ul>

        </div>
    </div>
</template>

<style scoped>
.card-container {
    display: flex;
    border: 2px solid #ccc;
    padding: 10px;
    background-color: rgba(217, 217, 217, 0.3);
    border: 2px solid var(--orange);
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.3);
    position: relative;
}

ul {
    list-style: none;
    margin-left: 5rem;
    padding: 5px;
}

.title {
    font-family: Poppins;
    font-size: 1.25rem;
    font-style: normal;
    font-weight: 600;
    line-height: normal;
    padding-left: 4rem;

}

li {
    padding-left: 3rem;
}

.image-container {
    flex: 1;
    max-width: 20%;
    position: absolute;
    top: -25px;
    left: -10px;
    bottom: -10px;
}

.image-container img {
    width: 9.75rem;
    height: 9.75rem;
    border-radius: 50%;
    border: 2px solid var(--orange);
}

.content-container {
    flex: 6;
    padding-left: 20px;
}

.line2,
.line3 {
    display: flex;
}

.line2 li,
.line3 li {
    margin-right: 20px;
}

.image-container {
    padding-top: 2%;
}
</style>

